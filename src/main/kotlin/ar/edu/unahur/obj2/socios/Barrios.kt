package ar.edu.unahur.obj2.socios

abstract class Barrio{
    abstract fun cuenta(monto: Double): Double
}

object lasRosas : Barrio() {
    override fun cuenta(monto: Double) = monto + 50
}

object lasLauchas : Barrio() {
    override fun cuenta(monto: Double) = monto / 2
}

object barrioVerde : Barrio() {
    override fun cuenta(monto: Double): Double {
        return when {
            monto <= 200 -> 200.0
            else -> monto
        }
    }
}

object lasTorres : Barrio() {
    override fun cuenta(monto: Double) = monto
}

