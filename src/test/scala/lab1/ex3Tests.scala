package lab1

import org.scalatest._
import chiseltest._
import chisel3._

class ex3Tests extends FreeSpec with ChiselScalatestTester {

  "Exercise 3" in {
    test(new ex3(8,255)) { c =>
      c.clock.step(1)
    //   c.io.result.expect(0.B)
    //   c.io.oo.expect(1.B)
    //   c.io.aa.expect(15.S)
    }
  }
}