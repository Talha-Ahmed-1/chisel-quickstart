package lab8

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class ex3Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 8 Ex 3" in {
    test(new ex3) { c =>
      c.io.instW.poke("b101".U)
      c.io.write.poke(true.B)
      c.io.addr.poke(2.U)
      c.clock.step(2)
      c.io.write.poke(false.B)
      c.io.addr.poke(2.U)
      // c.io.instR.expect()
      c.clock.step(20)
    }
  }
}