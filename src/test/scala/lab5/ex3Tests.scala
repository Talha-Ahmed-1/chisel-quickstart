package lab5

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class ex3Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 5 Ex 3" in {
    test(new ex3(4,UInt(16.W))(_-_)) { c =>
      c.io.in(0).poke(10.U)
      c.io.in(1).poke(4.U)
      c.io.in(2).poke(3.U)
      c.io.in(3).poke(2.U)
      c.io.out(0).expect(10.U)
      c.io.out(1).expect(4.U)
      c.io.out(2).expect(3.U)
      c.io.out(3).expect(1.U)
    }
  }
}