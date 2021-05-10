package ar.edu.unahur.obj2.socios

class Cliente(var estadoDeAnimo: EstadoDeAnimo,var bolsillo: Double,var barrio: Barrio) {
    lateinit var pedido : Pedido
    fun hacerPedido(comida: Pedido){ this.pedido = comida }
    fun consultarPropina() = this.estadoDeAnimo.propina(this) //TRATAR DE SACAR BOLSILLO DEL PARAMETRO YA QUE SOLO SE UTILIZA EN 1 ESTADO DE ANIMO
    fun consultarPropinaBarrio() = this.barrio.cuenta(this.consultarPropina())
    fun cambiarBarrio(nuevoBarrio: Barrio) { barrio = nuevoBarrio}
    fun cambiarEstadoDeAnimo(nuevoEstado: EstadoDeAnimo) { estadoDeAnimo = nuevoEstado }
    fun cambiarBolsillo(nuevoBolsillo: Double) { bolsillo = nuevoBolsillo }
}
interface EstadoDeAnimo {
    fun propina(cliente: Cliente) : Double
}

class Enojado() : EstadoDeAnimo {
    override fun propina(cliente: Cliente) = 0.0 //Pedido
}

class Feliz() : EstadoDeAnimo {
    override fun propina(cliente: Cliente) = cliente.pedido.precio * 0.25 //Deja como propina el 25% de lo que salió el pedido
}

class Indiferente() : EstadoDeAnimo {
    override fun propina(cliente: Cliente) = cliente.bolsillo //Deja como propina lo que tenga en el bolsillo.
}

class Resfriado() : EstadoDeAnimo {
    override fun propina(cliente: Cliente) = cliente.pedido.precio//Le invade el sentimiento de culpa y le deja de propina el 100% de lo que salió el pedido.
}
