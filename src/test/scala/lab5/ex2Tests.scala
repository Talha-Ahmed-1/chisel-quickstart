package lab5

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class ex2Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 5 Ex 2" in {
    test(new ex2(UInt(32.W))) { c =>
      c.io.in1.poke(2.U)
      c.io.in2.poke(3.U)
      c.io.sel.poke(1.B)
      c.io.out.expect(3.U)
    }
  }
}