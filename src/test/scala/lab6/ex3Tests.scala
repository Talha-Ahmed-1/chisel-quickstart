package lab6

import org.scalatest._
import chiseltest._
import chisel3._

class ex3Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 6 Exercise 3" in {
    test(new ex3(5)) { c =>
      c.clock.step(20)
    //   c.io.result.expect(0.B)
    //   c.io.oo.expect(1.B)
    //   c.io.aa.expect(15.S)
    }
  }
}