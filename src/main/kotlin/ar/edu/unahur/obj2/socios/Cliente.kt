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

// Como los estados son unicos y no cambian en si, pasaron de ser clases a objetos.

object Enojado : EstadoDeAnimo {
    override fun propina(pedido: Pedido,bolsillo: Double) = 0.0 //Pedido
}

object Feliz : EstadoDeAnimo {
    override fun propina(pedido: Pedido,bolsillo: Double) = pedido.precio * 0.25 //Deja como propina el 25% de lo que salió el pedido
}

object Indiferente : EstadoDeAnimo {
    override fun propina(pedido: Pedido,bolsillo: Double) = bolsillo //Deja como propina lo que tenga en el bolsillo.
}

object Resfriado : EstadoDeAnimo {
    override fun propina(pedido: Pedido,bolsillo: Double) = pedido.precio //Le invade el sentimiento de culpa y le deja de propina el 100% de lo que salió el pedido.
}




