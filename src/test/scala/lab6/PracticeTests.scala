package lab6

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class PracticeTests extends FreeSpec with ChiselScalatestTester {

  "Lab 5 Task 3" in {
    test(new Practice) { c =>
      c.io.in.bits.poke(5.U)
      c.io.in.valid.poke(true.B)
      c.clock.step(20)
      // c.io.out.expect(0.B)
    }
  }
}