package lab3

import org.scalatest._
import chiseltest._
import chisel3._

class ex2Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 3 ALU" in {
    test(new ex2()) { c =>
      c.io.in_A.poke(10.U)
      c.io.in_B.poke(20.U)
      c.io.alu_Op.poke(4.U)
      c.clock.step(1)
      c.io.sum.expect(30.U)
      c.io.out.expect(30.U)
    }
  }
}