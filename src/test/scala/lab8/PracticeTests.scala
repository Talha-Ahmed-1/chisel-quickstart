package lab8

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class PracticeTests extends FreeSpec with ChiselScalatestTester {

  "Lab 8 Practice" in {
    test(new Practice) { c =>

      c.io.enable.poke(1.B)
      c.io.dataIn(0).poke(2.U)
      c.io.addr.poke(5.U)
      c.io.write.poke(1.B)
      c.io.mask(3).poke(1.B)
      c.clock.step(20)


      /////////////////////////

      // c.io.dataIn.poke(2.U)
      // c.io.addr.poke(5.U)
      // c.io.wr_enable.poke(1.B)
      // c.io.rd_enable.poke(1.B)

      /////////////////////////

      // c.io.data_in(0).poke(2.U)
      // c.io.data_selector.poke(0.U)
      // c.io.addr.poke(5.U)
      // c.io.wr_en.poke(1.B)
      // c.clock.step(20)
    }
  }
}