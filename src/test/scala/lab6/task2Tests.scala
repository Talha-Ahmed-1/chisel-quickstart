package lab6

import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class task2Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 6 Task 2" in {
  test(new task2).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
    c.clock.step(20)
    c.io.out.expect(0.U)

    }
  }
}