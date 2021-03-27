package lab3

import org.scalatest._
import chiseltest._
import chisel3._


class example1Tests extends FreeSpec with ChiselScalatestTester {

  "Example1 lab3" in {
    test(new example1()) { c =>
    //   c.io.in.poke("b01".U)
      c.clock.step(10)
    //   c.io.out.expect("b0010".U)
    }
  }
}