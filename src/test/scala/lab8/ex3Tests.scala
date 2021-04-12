package lab8

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class ex3Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 8 Ex 3" in {
    test(new ex3) { c =>

      c.io.addr.poke(2.U)
      c.clock.step(20)
    }
  }
}