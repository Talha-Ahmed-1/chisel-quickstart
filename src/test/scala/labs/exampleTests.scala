package labs

import org.scalatest._
import chiseltest._
import chisel3._

class exampleTests extends FreeSpec with ChiselScalatestTester {

  "Test the Example" in {
    test(new example(5.U)) { c =>
      c.clock.step(1)
      c.io.result.expect(0.B)
      c.io.max.expect(31.U)

    }
  }
}