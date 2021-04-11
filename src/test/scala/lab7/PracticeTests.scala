package lab7

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class PracticeTests extends FreeSpec with ChiselScalatestTester {

  "Lab 7 Practice" in {
    test(new Practice(new UART_Params)) { c =>
      c.io.en.poke(1.B)
      c.io.div.poke(2.U)
      c.io.nstop.poke(2.U)
      c.io.in.bits.poke(20.U)
      c.io.in.valid.poke(1.B)
      c.clock.step(20)
    }
  }
}