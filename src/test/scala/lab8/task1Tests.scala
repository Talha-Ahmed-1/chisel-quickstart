package lab8

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class task1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 8 Task 1" in {
    test(new task1).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
      c.io.requestor(0).bits.poke(5.U)
      c.io.requestor(1).bits.poke(15.U)
      c.io.requestor(2).bits.poke(25.U)
      c.io.requestor(3).bits.poke(35.U)
      c.io.requestor(0).valid.poke(1.B)
      c.io.requestor(1).valid.poke(0.B)
      c.io.requestor(2).valid.poke(0.B)
      c.io.requestor(3).valid.poke(0.B)
      c.io.Writeaddr.poke(8.U)
      c.io.Readaddr.poke(8.U)
      c.clock.step(20)
    }
  }
}