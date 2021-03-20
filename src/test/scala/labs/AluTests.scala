package labs

import org.scalatest._
import chiseltest._
import chisel3._

class AluTests extends FreeSpec with ChiselScalatestTester {

  "Test the Alu" in {
    test(new Alu) { c =>
      c.io.AluControl.poke(0.U)
      c.io.in1.poke(0.S)
      c.io.in2.poke(8192.S)
      c.clock.step(1)
      c.io.out.expect(8192.S)
      c.io.Branch.expect(0.U)

    }
  }
}