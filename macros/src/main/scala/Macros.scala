

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing


import scala.language.experimental.macros
import scala.reflect.macros.Context


// private[sing]
object Macros {


    type AsBoxed = macro AsBoxedImpl

    def AsBoxedImpl(c: Context): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"
        val zuper: c.Tree = tq"$singlib.ReferenceEquality"

        val Template(parents, _, body) = c.enclosingTemplate
        val newBody = body ++ kindIdDef(c) ++ selfDef(c) ++ unsingDef(c) ++ naturalOrderingDef(c)
        val res = Template(replace(c)(parents, zuper), emptyValDef, newBody)
        //println(res.toString)
        res
    }


    type New = macro NewImpl

    def NewImpl(c: Context): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"
        val zuper: c.Tree = tq"$singlib.Any"

        val Template(parents, _, body) = c.enclosingTemplate
        val newBody = body ++ selfDef(c)
        Template(replace(c)(parents, zuper), emptyValDef, newBody)
    }


    type HasKindId = macro HasKindIdImpl

    def HasKindIdImpl(c: Context): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"
        val zuper: c.Tree = tq"$singlib.AnyKind"

        provideKindIdDef(c)(zuper)
    }


    type NewKind = macro NewKindImpl

    def NewKindImpl(c: Context): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"
        val zuper: c.Tree = tq"$singlib.Any"

        provideKindIdDef(c)(zuper)
    }


    def provideKindIdDef(c: Context)(zuper: c.Tree): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"
        val _trait: c.Tree = tq"$singlib.Any"

        val Template(parents, _, body) = c.enclosingTemplate
        val res = Template(replace(c)(parents, zuper), emptyValDef, body ++ kindIdDef(c))
        //println(res.toString)
        res
    }


    // Special thanks to: https://github.com/leonardschneider/macrogen

    type weakTypeOf[T](x: T) = macro weakTypeOfImpl[T]

    def weakTypeOfImpl[T: c.WeakTypeTag](c: Context)(x: c.Expr[T]): c.Tree = {
        import c.universe._
        tq"${weakTypeOf[T]}"
    }

    def selfDef(c: Context): List[c.Tree] = {
        import c.universe._

        val tdef = c.enclosingImpl match {
            case ClassDef(_, name, tparams, _) if tparams.length > 0 => {
                val targs = tparams.map(t => tq"${t.name}")
                q"override type self = $name[..$targs]"
            }
            case ClassDef(_, name, _, _) => {
                q"override type self = $name"
            }
            case ModuleDef(_, name, _) => {
                q"override type self = $name.type"
            }
        }

        List(tdef)
    }

    def replace(c: Context)(parents: List[c.Tree], to: c.Tree): List[c.Tree] = {
        parents.map { x =>
            if (x.equalsStructure(c.macroApplication)) to else x
        }
    }


    def naturalOrderingDef(c: Context): List[c.Tree] = {
        import c.universe._
        val vdef = q"override lazy val naturalOrdering: naturalOrdering = kindId.naturalOrdering"
        val tdef = q"override     type naturalOrdering                  = kindId#naturalOrdering"
        List(vdef, tdef)
    }


    def unsingDef(c: Context): List[c.Tree] = {
        import c.universe._

        val Template(_, _, body) = c.enclosingTemplate

        body match {
            case ValDef(_, TermName("unsing"), tpt, _) :: _ => {
                List( q"override type unsing = $tpt" )
            }
            case _ => Nil
        }
    }


    def kindIdDef(c: Context): List[c.Tree] = {
        import c.universe._

        val fullName = c.enclosingImpl.symbol.fullName.toString
        val (vkid, tkid) = skindId(c)(fullName)

        val vdef = q"override lazy val kindId: kindId = $vkid"
        val tdef = q"override     type kindId         = $tkid"

        List(vdef, tdef)
    }

    def skindId(c: Context)(fullName: String): (c.Tree, c.Tree) = {
        val _ids = fullName.split("\\.").
            reverse. // for a faster search
            toList.
            filterNot(s => s == "type")

        val ids = _ids.take(2) // because scalac is too slow

        val v = vmkKindId(c)( vmkList(c)( ids.map { id => vmkNat(c)(mkBooleans(id)) } ) )
        val t = tmkKindId(c)( tmkList(c)( ids.map { id => tmkNat(c)(mkBooleans(id)) } ) )
        (v, t)
    }

    // KindId construction from Nat List
    def vmkKindId(c: Context)(impl: c.Tree): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"

        val mk: c.Tree = q"$singlib.KindId.From"
        Apply(mk, List(impl))
    }

    def tmkKindId(c: Context)(impl: c.Tree): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"

        val mk: c.Tree = tq"$singlib.KindId.From"
        AppliedTypeTree(mk, List(impl))
    }


    // Nat List --> n1 :: n2 :: ... :: Nil
    def vmkList(c: Context)(ns: List[c.Tree]): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"

        val vnil: c.Tree = q"$singlib.list.Nil"
        val vcons: c.Tree = q"$singlib.list.Cons"

        ns.foldRight(vnil) { (n, x) => Apply(vcons, List(n, x)) }
    }

    def tmkList(c: Context)(ns: List[c.Tree]): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"

        val tnil: c.Tree = tq"$singlib.list.Nil"
        val tcons: c.Tree = tq"$singlib.list.Cons"

        ns.foldRight(tnil) { (n, x) => AppliedTypeTree(tcons, List(n, x)) }
    }


    // Boolean List --> a Nat
    def vmkNat(c: Context)(bs: List[Boolean]): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"

        val vzero: c.Tree = q"$singlib.`false`"
        val vone: c.Tree  = q"$singlib.`true`"
        val vnil: c.Tree  = q"$singlib.nat.dense.Nil"
        val vcons: c.Tree = q"$singlib.nat.dense.Cons"
        def vbit(b: Boolean): c.Tree = if (b) vone else vzero

        bs.foldRight(vnil) { (b, x) => Apply(vcons, List(vbit(b), x)) }
    }

    def tmkNat(c: Context)(bs: List[Boolean]): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"

        val tzero: c.Tree = tq"$singlib.`false`"
        val tone: c.Tree  = tq"$singlib.`true`"
        val tnil: c.Tree  = tq"$singlib.nat.dense.Nil"
        val tcons: c.Tree = tq"$singlib.nat.dense.Cons"
        def tbit(b: Boolean): c.Tree = if (b) tone else tzero

        bs.foldRight(tnil) { (b, x) => AppliedTypeTree(tcons, List(tbit(b), x)) }
    }


    // See: http://stackoverflow.com/questions/16267771/how-to-convert-a-seqbyte-into-an-arrayboolean-representing-each-bit-in-scala

    private def mkBooleans(from: String): List[Boolean] = {
        removeTrailingFalse(stringToBooleans(from)).toList
    }

    // For the constraint of dense
    private def removeTrailingFalse(from: List[Boolean]): List[Boolean] = {
        from.reverse.dropWhile(_ == false).reverse.toList
    }

    private def stringToBooleans(from: String): List[Boolean] = {
        from.getBytes("UTF-8").flatMap(b => byteToBooleans(b)).toList
    }

    private def byteToBooleans(b: Byte): List[Boolean] = (0 to 7).map(isBitSet(b)).toList

    private def isBitSet(byte: Byte)(bit: Int): Boolean = ((byte >> bit) & 1) == 1
}

