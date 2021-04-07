package lab6

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class PracticeTests extends FreeSpec with ChiselScalatestTester {

  "Lab 5 Task 3" in {
    test(new Practice(10)) { c =>
      // c.io.in.poke(true.B)
      c.clock.step(20)
      // c.io.out.expect(20.U)
    }
  }
}