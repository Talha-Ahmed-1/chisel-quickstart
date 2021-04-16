package lab8

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class ex1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 8 Ex 1" in {
    test(new ex1).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>

      c.io.dataIn(0).poke(15.U)
      c.io.dataIn(1).poke(7.U)
      c.io.dataIn(2).poke(10.U)
      c.io.dataIn(3).poke(99.U)
      c.io.addr.poke(3.U)
      c.io.enable.poke(true.B)
      c.io.write.poke(1.B)
      c.io.mask(0).poke(0.B)
      c.io.mask(1).poke(1.B)
      c.io.mask(2).poke(0.B)
      c.io.mask(3).poke(0.B)
      c.clock.step(20)
    }
  }
}