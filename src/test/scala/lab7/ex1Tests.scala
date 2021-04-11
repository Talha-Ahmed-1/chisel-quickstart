package lab7

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class ex1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 7 Ex 1" in {
  test(new ex1).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
      c.io.in1.bits.poke("b1100".U)
      c.io.in2.bits.poke("b1001".U)
      c.io.in1.valid.poke(1.B)
      c.io.in2.valid.poke(1.B)
      c.clock.step(20)
      // c.io.out.expect(0.B)
    }
  }
}