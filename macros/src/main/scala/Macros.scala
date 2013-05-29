

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.

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
        val _trait: c.Tree = tq"$singlib.ReferenceEquality"

        val Template(parents, self, body) = c.enclosingTemplate
        val newBody = body ++ typeIdDef(c) ++ selfDef(c) ++ unsingDef(c) ++ naturalOrderingDef(c)
        val res = Template(replace(c)(parents, tq"AsBoxed", _trait), emptyValDef, newBody)
        println(res.toString)
        res
    }

    type AsType = macro AsTypeImpl

    def AsTypeImpl(c: Context): c.Tree = {
        import c.universe._

        val _trait: c.Tree = tq"com.github.okomok.sing.Type"

        val Template(parents, self, body) = c.enclosingTemplate
        val res = Template(replace(c)(parents, tq"AsType", _trait), emptyValDef, body ++ typeIdDef(c))
        //println(res.toString)
        res
    }

    def replace(c: Context)(parents: List[c.Tree], from: c.Tree, to: c.Tree): List[c.Tree] = {
        parents.map { x =>
            if (x.equalsStructure(from)) to else x
        }
    }

    def selfDef(c: Context): List[c.Tree] = {
        import c.universe._

        val Template(parents, self, defs) = c.enclosingTemplate

        val tdef = c.enclosingImpl match {
            case ClassDef(_, name, tparams, _) if tparams.length > 0 => {
                val targs = tparams.map(t => tq"${t.name}")
                q"override type self = $name[..$targs]"
            }
            case ClassDef(_, name, _, _) => {
                q"override type self = $name"
            }
            case ModuleDef(_, name, _) => {
                q"override type self = $name .type"
            }
        }

        List(tdef)
    }

    def naturalOrderingDef(c: Context): List[c.Tree] = {
        import c.universe._
        val vdef = q"override  val naturalOrdering: naturalOrdering = typeId.naturalOrdering"
        val tdef = q"override type naturalOrdering                  = typeId#naturalOrdering"
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

    def typeIdDef(c: Context): List[c.Tree] = {
        import c.universe._

        val idname = c.enclosingImpl.name.toString // c.enclosingImpl.symbol.fullName.toString ~ stack overflows...

        val singlib: c.Tree = q"com.github.okomok.sing"

        val zero: c.Tree = q"$singlib.`false`"
        val one: c.Tree = q"$singlib.`true`"
        val nil: c.Tree = q"$singlib.nat.dense.Nil"
        val cons: c.Tree = q"$singlib.nat.dense.Cons"

        val tzero: c.Tree = tq"$singlib.`false`"
        val tone: c.Tree = tq"$singlib.`true`"
        val tnil: c.Tree = tq"$singlib.nat.dense.Nil"
        val tcons: c.Tree = tq"$singlib.nat.dense.Cons"

        def bit(b: Boolean): c.Tree = if (b) one else zero
        def tbit(b: Boolean): c.Tree = if (b) tone else tzero

        val bs = mkBooleans(idname)

        val id = bs.foldRight(nil) { (b, x) => Apply(cons, List(bit(b), x)) }
        val tid = bs.foldRight(tnil) { (b, x) => AppliedTypeTree(tcons, List(tbit(b), x)) }

        // c.echo(NoPosition, id.toString)

        val vdef = q"override  val typeId: typeId = $id"
        val tdef = q"override type typeId         = $tid"

        List(vdef, tdef)
    }

    // See: http://stackoverflow.com/questions/16267771/how-to-convert-a-seqbyte-into-an-arrayboolean-representing-each-bit-in-scala

    private def mkBooleans(from: String): Array[Boolean] = {
        removeTrailingFalse(stringToBooleans(from))
    }

    // For the constraint of dense
    private def removeTrailingFalse(from: Array[Boolean]): Array[Boolean] = {
        from.reverse.dropWhile(_ == false).reverse
    }

    private def stringToBooleans(from: String): Array[Boolean] = {
        from.getBytes("UTF-8").flatMap(b => byteToBooleans(b))
    }

    private def byteToBooleans(b: Byte): Seq[Boolean] = 0 to 7 map isBitSet(b)

    private def isBitSet(byte: Byte)(bit: Int): Boolean = ((byte >> bit) & 1) == 1
}
