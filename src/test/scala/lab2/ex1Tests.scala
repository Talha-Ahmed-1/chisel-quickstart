package lab2

import org.scalatest._
import chiseltest._
import chisel3._

class ex1Tests extends FreeSpec with ChiselScalatestTester {

  "Exercise 1 Lab 2" in {
    test(new ex1()) { c =>
      c.io.in_A.poke(30.U)
      c.io.in_B.poke(40.U)
      c.io.select.poke(0.B)
      c.clock.step(1)
      c.io.out.expect(40.U)
    }
  }
}