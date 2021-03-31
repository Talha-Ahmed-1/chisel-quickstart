package lab4

import org.scalatest._
import chiseltest._
import chisel3._

class task2Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 4 Task 2" in {
    test(new task2()) { c =>
      // c.io.instr.poke(103838099.U)
      c.io.instr.poke("h01700013".U)
      c.io.pc.poke(1.U)
      c.io.immd_se.expect(23.U)
    //   c.io.arg_x.poke(20.U)
    //   c.io.arg_y.poke(20.U)
    //   c.io.fnct3.poke("b000".U)
    //   c.io.branch.poke(1.B)
    //   c.io.br_taken.expect(1.B)
    }
  }
}
