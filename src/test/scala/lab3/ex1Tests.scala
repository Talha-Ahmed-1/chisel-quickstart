package lab3

import org.scalatest._
import chiseltest._
import chisel3._

class ex1Tests extends FreeSpec with ChiselScalatestTester {

  "Exercise 1 Lab 3" in {
    test(new ex1()) { c =>
      c.io.in1.poke(0.B)
      c.io.in2.poke(1.B)
      c.io.in3.poke(0.B)
      c.io.in4.poke(0.B)
      c.io.out.expect(1.U)
    }
  }
}