package lab2

import org.scalatest._
import chiseltest._
import chisel3._

class ex2Tests extends FreeSpec with ChiselScalatestTester {

  "Exercise 2 Lab 2" in {
    test(new ex2()) { c =>
      c.io.in1.poke(1.B)
      c.io.in2.poke(0.B)
      c.io.in3.poke(1.B)
      c.io.in4.poke(0.B)
      c.io.in5.poke(1.B)
      c.io.in6.poke(0.B)
      c.io.in7.poke(1.B)
      c.io.sel.poke(7.U)
      c.clock.step(1)
      c.io.out.expect(1.B)
    }
  }
}