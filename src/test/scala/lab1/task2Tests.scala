package lab1

import org.scalatest._
import chiseltest._
import chisel3._

class task2Tests extends FreeSpec with ChiselScalatestTester {

  "Task 2" in {
    test(new task2(5) { c =>
      // c.io.reload.poke(1.B)
      // c.io.reload.poke(0.B)
      c.io.out.expect(0.B)
      c.clock.step(1)
    //   c.io.result.expect(0.B)
    //   c.io.oo.expect(1.B)
    //   c.io.aa.expect(15.S)
    })
  }
}