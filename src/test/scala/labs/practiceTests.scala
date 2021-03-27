package labs

import org.scalatest._
import chiseltest._
import chisel3._

class practiceTests extends FreeSpec with ChiselScalatestTester {

  "Task 2" in {
    test(new practice(5) { c =>
      // c.io.reload.poke(1.B)
      // c.io.reload.poke(0.B)
      c.io.out.expect(0.B)
      c.clock.step(10)
    })
  }
}