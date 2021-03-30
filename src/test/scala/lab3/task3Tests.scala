package lab3

import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class task3Tests extends FreeSpec with ChiselScalatestTester {
  "Lab 3 Task 3" in {
    test(new task3()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
        c.io.in.poke("b11".U)
        c.clock.step(20)
        c.io.out.valid.expect(1.B)
        c.io.out.bits.expect("b1000".U)
    }
  }
}






// test(new task3()) { c =>
    //     c.io.in.bits.poke(5.U)
    //     c.io.in.valid.poke(0.B)
    //     c.clock.step(5)
    //     c.io.out.valid.expect(1.B)
    //     c.io.out.bits.expect(5.U)
    // }