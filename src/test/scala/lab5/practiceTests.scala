package lab5

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class practiceTests extends FreeSpec with ChiselScalatestTester {

  "Lab 5 Practice" in {
    test(new practice(64)) { c =>
      c.io.arg_x.poke(2000.U)
      c.io.arg_y.poke(3000.U)
      c.io.alu_oper.poke(2.U)
      c.io.alu_out.expect(5000.U)
      println(log2Ceil(32))
    }
  }
}