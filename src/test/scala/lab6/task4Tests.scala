package lab6

import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class task4Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 6 Task 4" in {
  test(new task4).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
    c.io.up_down.poke(true.B)
    c.clock.step(20)
    // c.io.out.expect(0.U)
    c.io.up_down.poke(false.B)
    c.clock.step(20)
    // c.io.out.expect(0.U)

    }
  }
}