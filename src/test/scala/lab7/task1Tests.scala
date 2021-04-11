package lab7

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class task1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 7 Task 1" in {
  test(new task1).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
      c.io.f1.poke(1.B)
      c.io.f2.poke(0.B)
      c.io.r1.poke(1.B)
      c.io.r2.poke(0.B)
      c.clock.step(20)
      c.io.out.expect(7.U)
    }
  }
}