package lab1

import org.scalatest._
import chiseltest._
import chisel3._

class ex1Tests extends FreeSpec with ChiselScalatestTester {

  "Exercise 1" in {
    test(new ex1(5.U)) { c =>
      c.clock.step(1)
      c.io.result.expect(0.B)
    }
  }
}