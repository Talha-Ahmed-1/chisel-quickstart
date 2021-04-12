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

      c.clock.step(20)
    }
  }
}