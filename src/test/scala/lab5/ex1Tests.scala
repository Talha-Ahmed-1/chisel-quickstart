package lab5

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class ex1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 5 Ex 1" in {
    test(new ex1(64)) { c =>
      c.io.arg_x.poke(2000.U)
      c.io.arg_y.poke(3000.U)
      c.io.alu_oper.poke(2.U)
      c.io.alu_out.expect(5000.U)
      println(log2Ceil(32))
    }
  }
}