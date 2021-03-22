package lab2

import org.scalatest._
import chiseltest._
import chisel3._

class task2Tests extends FreeSpec with ChiselScalatestTester {

  "Task2 Lab 2" in {
    test(new task2()) { c =>
    //   c.io.in.poke(Vec(1.B, 0.B, 1.B, 0.B))
    // c.io.in.poke(Map(Vec(0.U) -> 1.U))
    //   c.io.sel.poke(Vec(0.B, 1.B))
    c.io.in(0).poke(1.B)
    c.io.in(1).poke(0.B)
    c.io.in(2).poke(1.B)
    c.io.in(3).poke(0.B)
    c.io.sel(0).poke(0.B)
    c.io.sel(0).poke(0.B)
      
    //   c.io.sel.poke(7.U)
      c.clock.step(1)
    c.io.out(0).expect(0.B)
    //   c.io.out.expect(Vec(0.B, 0.B, 0.B, 0.B))
    //   c.io.out2.expect(0.B)
    }
  }
}