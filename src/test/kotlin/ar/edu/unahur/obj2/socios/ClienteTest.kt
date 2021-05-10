package ar.edu.unahur.obj2.socios

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClienteTest : DescribeSpec({
  // 1.Saber cuánta propina dejaría un/a cliente para un pedido de un determinado importe, teniendo en cuenta su estado de ánimo.
  // 2.Incorporar a la cuenta anterior la variación que pueda surgir según el barrio.

  val pedidoPizza = Pedido(1000.0)
  val pedidoEmpanadas = Pedido(1500.0)
  val pedidoMilanesa = Pedido(500.0)
  val pedidoHelado = Pedido(150.0)


  //Hacer 2 tests por cada cliente con estado de animo diferente (enojado,feliz,indiferente,resfriado)
  //Luego, hacer lo mismo pero aplicando los barrios (lasRosas,lasLauchas,barrioVerde,lasTorres)

  describe("Un/a cliente enojado") {
    it("Va a dejar N propina para un pedido de M importe"){
    //.Saber cuánta propina dejaría un/a cliente para un pedido de un determinado importe, teniendo en cuenta su estado de ánimo.
      Cliente.consultarPropina().shouldBe(100.0)//Corregir valor
    }
  }


})
