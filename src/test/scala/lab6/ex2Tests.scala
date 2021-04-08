package lab6

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class ex2Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 5 Task 3" in {
    test(new ex2(13)) { c =>
      // c.io.in.poke("b1100".U)
      c.clock.step(20)
      // c.io.out.expect(0.B)
    }
  }
}