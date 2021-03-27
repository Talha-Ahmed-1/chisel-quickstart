package lab3

import org.scalatest._
import chiseltest._
import chisel3._

class task1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 3 ALU" in {
    test(new task1()) { c =>
      c.io.arg_x.poke(20.U)
      c.io.arg_y.poke(20.U)
      c.io.fnct3.poke("b000".U)
      c.io.branch.poke(1.B)
      c.io.br_taken.expect(1.B)
    }
  }
}
