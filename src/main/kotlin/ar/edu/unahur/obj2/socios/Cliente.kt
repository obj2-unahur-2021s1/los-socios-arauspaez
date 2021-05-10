package ar.edu.unahur.obj2.socios


object Cliente { //Patron Singleton aplicado
    lateinit var estadoDeAnimo: EstadoDeAnimo //Los atributos del creador fueron cambiados por 'lateinit var' ya que se van a declarar cuando sea necesario
    var bolsillo: Double = 0.0
    lateinit var pedido : Pedido
    lateinit var barrio: Barrio

    //Getters
    fun consultarPropina() = this.estadoDeAnimo.propina(pedido,bolsillo) //TRATAR DE SACAR BOLSILLO DEL PARAMETRO YA QUE SOLO SE UTILIZA EN 1 ESTADO DE ANIMO
    fun consultarPropinaBarrio() = this.barrio.cuenta(this.consultarPropina())

    //Setters
    fun hacerPedido(comida: Pedido){ pedido = comida }
    fun cambiarBarrio(nuevoBarrio: Barrio) { barrio = nuevoBarrio }
    fun cambiarEstadoDeAnimo(nuevoEstado: EstadoDeAnimo) { estadoDeAnimo = nuevoEstado }
    fun cambiarBolsillo(nuevoBolsillo: Double) { bolsillo = nuevoBolsillo }
}

interface EstadoDeAnimo {
    fun propina(pedido: Pedido,bolsillo: Double) : Double
}

class Enojado() : EstadoDeAnimo {
    override fun propina(pedido: Pedido,bolsillo: Double) = 0.0 //Pedido
}

class Feliz() : EstadoDeAnimo {
    override fun propina(pedido: Pedido,bolsillo: Double) = pedido.precio * 0.25 //Deja como propina el 25% de lo que salió el pedido
}

class Indiferente() : EstadoDeAnimo {
    override fun propina(pedido: Pedido,bolsillo: Double) = bolsillo //Deja como propina lo que tenga en el bolsillo.
}

class Resfriado() : EstadoDeAnimo {
    override fun propina(pedido: Pedido,bolsillo: Double) = pedido.precio //Le invade el sentimiento de culpa y le deja de propina el 100% de lo que salió el pedido.
}




