package ar.edu.unahur.obj2.socios

abstract class Barrio{
    abstract fun cuenta(monto: Double): Double
}

object lasRosas : Barrio() { //agrega un plus fijo de $50 a la propina,
    override fun cuenta(monto: Double) = monto + 50
}

object lasLauchas : Barrio() { //reduce a la mitad la propina,
    override fun cuenta(monto: Double) = monto / 2
}

object barrioVerde : Barrio() { //fija un mínimo de $200 para la propina,
    override fun cuenta(monto: Double): Double {
        return when {
            monto <= 200 -> 200.0
            else -> monto
        }
    }
}

object lasTorres : Barrio() { //no modifica en nada a la propina.
    override fun cuenta(monto: Double) = monto
}