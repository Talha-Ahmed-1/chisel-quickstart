package lab4

import chisel3 . _
import chisel3 . util._
import org.scalatest._
import chiseltest._
import scala . util . Random

class task1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 4 Task 1" in {
    test(new task1()) { c =>
      // c.io.arg_x.poke(40.U)
      // c.io.arg_y.poke(40.U)
      // c.io.fnct3.poke("b101".U)
      // c.io.branch.poke(1.B)
      // c.io.br_taken.expect(1.B)
      val array_funct3 = Array(0,1,4,6,5,7)
      for ( i <- 0 until 100) {
            val a = Random . nextLong () & 0xFFFFFFFFL
            val b = Random . nextLong () & 0xFFFFFFFFL
            // val branch = if (Random.nextInt(2) == 1) 1 else 2
            val branch = 1
            // val branch2 = if (Random.nextInt(2) == 1) 1 else 2
            val ff = Random . nextInt (6)
            val funct3 = array_funct3(ff)
            val result = ff match {
              // case 0 => Mux(a.U === b.U, 1.U, 0.U)
              // case 1 => Mux(a.U =/= b.U, 1.U, 0.U)
              // case 4 => Mux(a.U < b.U, 1.U, 0.U)
              // case 6 => Mux(a.U < b.U, 1.U, 0.U)
              // case 5 => Mux(a.U >= b.U, 1.U, 0.U)
              // case 7 => Mux(a.U >= b.U, 1.U, 0.U)
              case 0 => if (a == b) 1 else 0
              case 1 => if (a != b) 1 else 0
              case 4 => if (a < b) 1 else 0
              case 6 => if (a < b) 1 else 0
              case 5 => if (a >= b) 1 else 0
              case 7 => if (a >= b) 1 else 0
            }
        println("----funct3----",funct3)
        c.io.arg_x.poke(a.U)
        c.io.arg_y.poke(b.U)
        c.io.fnct3.poke(funct3.U)
        c.io.branch.poke(branch.B)
        c.clock.step(1)
        if (branch == 1 & result == 1)
          c.io.br_taken.expect(1.B)
        else 
          c.io.br_taken.expect(0.B)

      }
      c.clock.step(2)
    }
  }
}