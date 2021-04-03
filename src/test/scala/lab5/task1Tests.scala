package lab5

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class task1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 5 Task 1" in {
    test(new task1(4)) { c =>
      c.io.in0.poke(10.U)
      c.io.in1.poke(4.U)
      c.io.sum.expect(14.U)
    }
  }
}