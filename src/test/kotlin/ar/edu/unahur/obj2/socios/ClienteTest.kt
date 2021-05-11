package ar.edu.unahur.obj2.socios

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClienteTest : DescribeSpec({
  // REQUERIMIENTOS:
  // 1.Saber cuánta propina dejaría un/a cliente para un pedido de un determinado importe, teniendo en cuenta su estado de ánimo.
  // 2.Incorporar a la cuenta anterior la variación que pueda surgir según el barrio.

  val pedidoPizza = Pedido(1000.0)
  val pedidoEmpanadas = Pedido(1500.0)
  val pedidoMilanesa = Pedido(500.0)
  val pedidoHelado = Pedido(150.0)


  // CLIENTE ENOJADO
  describe("Un/a cliente ENOJADO") {
    it("Va a dejar 0 propina para un pedido de 1000 importe"){
      Cliente.cambiarEstadoDeAnimo(Enojado)
      Cliente.cambiarBolsillo(250.0)
      Cliente.hacerPedido(pedidoPizza)
      Cliente.consultarPropina().shouldBe(0.0)
    }
    it("Va a dejar 0 propina para un pedido de 1500 importe"){
      Cliente.cambiarEstadoDeAnimo(Enojado)
      Cliente.cambiarBolsillo(400.0)
      Cliente.hacerPedido(pedidoEmpanadas)
      Cliente.consultarPropina().shouldBe(0.0)
    }
    //No tiene sentido hacer el caso contrario ya que un cliente ENOJADO la propina que deje siempre va a ser igual a 0.
  }

  // CLIENTE ENOJADO QUE VIVE EN...
  describe("Un/a cliente ENOJADO que vive en LAS ROSAS") {
    it("Va a dejar 50 de propina para un pedido de 1000 importe"){
      Cliente.cambiarBarrio(lasRosas)
      Cliente.cambiarEstadoDeAnimo(Enojado)
      Cliente.cambiarBolsillo(20.0)
      Cliente.hacerPedido(pedidoPizza)
      Cliente.consultarPropinaBarrio().shouldBe(50.0)
    }
  }
  describe("Un/a cliente ENOJADO que vive en LAS LAUCHAS") {
    it("Va a dejar 0 de propina para un pedido de 150 importe"){
      Cliente.cambiarBarrio(lasLauchas)
      Cliente.cambiarEstadoDeAnimo(Enojado)
      Cliente.cambiarBolsillo(50.0)
      Cliente.hacerPedido(pedidoHelado)
      Cliente.consultarPropinaBarrio().shouldBe(0.0)
    }
  }
  describe("Un/a cliente ENOJADO que vive en BARRIO VERDE") {
    it("Va a dejar 200 de propina para un pedido de 1000 importe"){
      Cliente.cambiarBarrio(barrioVerde)
      Cliente.cambiarEstadoDeAnimo(Enojado)
      Cliente.cambiarBolsillo(0.0)
      Cliente.hacerPedido(pedidoMilanesa)
      Cliente.consultarPropinaBarrio().shouldBe(200.0)
    }
  }
  describe("Un/a cliente ENOJADO que vive en LAS TORRES") {
    it("Va a dejar 0 de propina para un pedido de 150 importe"){
      Cliente.cambiarBarrio(lasTorres)
      Cliente.cambiarEstadoDeAnimo(Enojado)
      Cliente.cambiarBolsillo(20.0)
      Cliente.hacerPedido(pedidoHelado)
      Cliente.consultarPropinaBarrio().shouldBe(0.0)
    }
  }

  //CLIENTE FELIZ
  describe("Un/a cliente FELIZ") {
    it("Va a dejar 250 propina para un pedido de 1000 importe"){
      Cliente.cambiarEstadoDeAnimo(Feliz)
      Cliente.cambiarBolsillo(300.0)
      Cliente.hacerPedido(pedidoPizza)
      Cliente.consultarPropina().shouldBe(250.0)
    }
    it("Va a dejar 125 propina para un pedido de 500 importe"){
      Cliente.cambiarEstadoDeAnimo(Feliz)
      Cliente.cambiarBolsillo(500.0)
      Cliente.hacerPedido(pedidoMilanesa)
      Cliente.consultarPropina().shouldBe(125.0)
    }
  }

  //CLIENTE FELIZ QUE VIVE EN...
  describe("Un/a cliente FELIZ que vive en LAS ROSAS") {
    it("Va a dejar 425 propina para un pedido de 1500 importe"){
      Cliente.cambiarBarrio(lasRosas)
      Cliente.cambiarEstadoDeAnimo(Feliz)
      Cliente.cambiarBolsillo(300.0)
      Cliente.hacerPedido(pedidoEmpanadas)
      Cliente.consultarPropinaBarrio().shouldBe(425.0)
    }
  }
  describe("Un/a cliente FELIZ que vive en LAS LAUCHAS") {
    it("Va a dejar 62.5 propina para un pedido de 500 importe"){
      Cliente.cambiarBarrio(lasLauchas)
      Cliente.cambiarEstadoDeAnimo(Feliz)
      Cliente.cambiarBolsillo(0.0)
      Cliente.hacerPedido(pedidoMilanesa)
      Cliente.consultarPropinaBarrio().shouldBe(62.5)
    }
  }
  describe("Un/a cliente FELIZ que vive en BARRIO VERDE") {
    it("Va a dejar 200 propina para un pedido de 150 importe"){
      Cliente.cambiarBarrio(barrioVerde)
      Cliente.cambiarEstadoDeAnimo(Feliz)
      Cliente.cambiarBolsillo(50.0)
      Cliente.hacerPedido(pedidoHelado)
      Cliente.consultarPropinaBarrio().shouldBe(200.0)
    }
    it("Va a dejar 375 propina para un pedido de 1500 importe"){
      Cliente.cambiarBarrio(barrioVerde)
      Cliente.cambiarEstadoDeAnimo(Feliz)
      Cliente.cambiarBolsillo(100.0)
      Cliente.hacerPedido(pedidoEmpanadas)
      Cliente.consultarPropinaBarrio().shouldBe(375.0)
    }
  }
  describe("Un/a cliente FELIZ que vive en LAS TORRES") {
    it("Va a dejar 250 propina para un pedido de 500 importe"){
      Cliente.cambiarBarrio(lasTorres)
      Cliente.cambiarEstadoDeAnimo(Feliz)
      Cliente.cambiarBolsillo(25.0)
      Cliente.hacerPedido(pedidoPizza)
      Cliente.consultarPropinaBarrio().shouldBe(250.0)
    }
  }

  //CLIENTE INDIFERENTE
  describe("Un/a cliente INDIFERENTE") {
    it("Va a dejar de propina 50 teniendo 50 en el bolsillo") {
      Cliente.cambiarEstadoDeAnimo(Indiferente)
      Cliente.cambiarBolsillo(50.0)
      Cliente.hacerPedido(pedidoHelado)
      Cliente.consultarPropina().shouldBe(50.0)
    }
    it("Va a dejar de propina 300 teniendo 300 en el bolsillo") {
      Cliente.cambiarEstadoDeAnimo(Indiferente)
      Cliente.cambiarBolsillo(300.0)
      Cliente.hacerPedido(pedidoEmpanadas)
      Cliente.consultarPropina().shouldBe(300.0)
    }
  }

  //CLIENTE INDIFERENTE QUE VIVE EN...
  describe("Un/a cliente INDIFERENTE que vive en LAS ROSAS") {
    it("Va a dejar de propina 150 teniendo 100 en el bolsillo") {
      Cliente.cambiarBarrio(lasRosas)
      Cliente.cambiarEstadoDeAnimo(Indiferente)
      Cliente.cambiarBolsillo(100.0)
      Cliente.hacerPedido(pedidoEmpanadas)
      Cliente.consultarPropinaBarrio().shouldBe(150.0)
    }
  }
  describe("Un/a cliente INDIFERENTE que vive en LAS LAUCHAS") {
    it("Va a dejar de propina 75 teniendo 150 en el bolsillo") {
      Cliente.cambiarBarrio(lasLauchas)
      Cliente.cambiarEstadoDeAnimo(Indiferente)
      Cliente.cambiarBolsillo(150.0)
      Cliente.hacerPedido(pedidoHelado)
      Cliente.consultarPropinaBarrio().shouldBe(75.0)
    }
  }
  describe("Un/a cliente INDIFERENTE que vive en BARRIO VERDE") {
    it("Va a dejar de propina 200 teniendo 100 en el bolsillo") {
      Cliente.cambiarBarrio(barrioVerde)
      Cliente.cambiarEstadoDeAnimo(Indiferente)
      Cliente.cambiarBolsillo(100.0)
      Cliente.hacerPedido(pedidoMilanesa)
      Cliente.consultarPropinaBarrio().shouldBe(200.0)
    }
    it("Va a dejar de propina 300 teniendo 300 en el bolsillo") {
      Cliente.cambiarBarrio(barrioVerde)
      Cliente.cambiarEstadoDeAnimo(Indiferente)
      Cliente.cambiarBolsillo(300.0)
      Cliente.hacerPedido(pedidoMilanesa)
      Cliente.consultarPropinaBarrio().shouldBe(300.0)
    }
  }
  describe("Un/a cliente INDIFERENTE que vive en LAS TORRES") {
    it("Va a dejar de propina 10 teniendo 10 en el bolsillo") {
      Cliente.cambiarBarrio(lasTorres)
      Cliente.cambiarEstadoDeAnimo(Indiferente)
      Cliente.cambiarBolsillo(10.0)
      Cliente.hacerPedido(pedidoPizza)
      Cliente.consultarPropinaBarrio().shouldBe(10.0)
    }
  }

  //CLIENTE RESFRIADO
  describe("Un/a cliente RESFRIADO") {
    it("Va a dejar de propina lo mismo que le salio el pedido (500.0)") {
      Cliente.cambiarEstadoDeAnimo(Resfriado)
      Cliente.cambiarBolsillo(150.0)
      Cliente.hacerPedido(pedidoMilanesa)
      Cliente.consultarPropina().shouldBe(500.0)
    }
    it("Va a dejar de propina lo mismo que le salio el pedido (1000.0)") {
      Cliente.cambiarEstadoDeAnimo(Resfriado)
      Cliente.cambiarBolsillo(327.0)
      Cliente.hacerPedido(pedidoPizza)
      Cliente.consultarPropina().shouldBe(1000.0)
    }
  }

  //CLIENTE RESFRIADO QUE VIVE EN...
  describe("Un/a cliente RESFRIADO que vive en LAS ROSAS") {
    it("Va a dejar de propina 1000 para un pedido de 1000") {
      Cliente.cambiarBarrio(lasRosas)
      Cliente.cambiarEstadoDeAnimo(Resfriado)
      Cliente.cambiarBolsillo(50.0)
      Cliente.hacerPedido(pedidoPizza)
      Cliente.consultarPropinaBarrio().shouldBe(1050.0)
    }
  }
  describe("Un/a cliente RESFRIADO que vive en LAS LAUCHAS") {
    it("Va a dejar de propina 750 para un pedido de 1500") {
      Cliente.cambiarBarrio(lasLauchas)
      Cliente.cambiarEstadoDeAnimo(Resfriado)
      Cliente.cambiarBolsillo(10.0)
      Cliente.hacerPedido(pedidoEmpanadas)
      Cliente.consultarPropinaBarrio().shouldBe(750.0)
    }
  }
  describe("Un/a cliente RESFRIADO que vive en BARRIO VERDE") {
    it("Va a dejar de propina 200 para un pedido de 150") {
      Cliente.cambiarBarrio(barrioVerde)
      Cliente.cambiarEstadoDeAnimo(Resfriado)
      Cliente.cambiarBolsillo(300.0)
      Cliente.hacerPedido(pedidoHelado)
      Cliente.consultarPropinaBarrio().shouldBe(200.0)
    }
  }
  describe("Un/a cliente RESFRIADO que vive en LAS TORRES") {
    it("Va a dejar de propina 500 para un pedido de 500") {
      Cliente.cambiarBarrio(lasTorres)
      Cliente.cambiarEstadoDeAnimo(Resfriado)
      Cliente.cambiarBolsillo(1000.0)
      Cliente.hacerPedido(pedidoMilanesa)
      Cliente.consultarPropinaBarrio().shouldBe(500.0)
    }
  }
})
