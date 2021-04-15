package lab7

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class task2Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 7 Task 2" in {
  test(new task2).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
      c.io.start.poke(1.B)
      c.clock.step(1)
      c.io.in.poke(1.U)
      c.clock.step(1)
      c.io.in.poke(1.U)
      c.clock.step(1)
      c.io.in.poke(0.U)
      c.clock.step(1)
      c.io.in.poke(1.U)
      c.clock.step(1)
      c.io.in.poke(0.U)
      c.clock.step(1)
      c.io.in.poke(0.U)
      c.io.start.poke(0.B)
      c.clock.step(1)
      c.io.out.expect(52.U)
      c.clock.step(5)
    }
  }
}