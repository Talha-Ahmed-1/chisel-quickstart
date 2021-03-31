package lab4

import chisel3 . _
import chisel3 . util._
import org.scalatest._
import chiseltest._
import scala . util . Random

class task1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 4 Task 1" in {
    test(new task1()) { c =>
      // c.io.arg_x.poke(3941490919.U)
      // c.io.arg_y.poke(3693344771.U)
      // c.io.fnct3.poke(4.U)
      // c.io.branch.poke(0.B)
      // c.io.br_taken.expect(0.B)
      val array_funct3 = Array(0,1,4,6,5,7)
      for ( i <- 0 until 100) {
            val a = Random . nextLong () & 0xFFFFFFFFL
            val b = Random . nextLong () & 0xFFFFFFFFL
            val branch = Random.nextBoolean()
            val ff = Random . nextInt (5)
            val funct3 = array_funct3(ff)
            val result = funct3 match {
              case 0 => if (a == b) 1 else 0
              case 1 => if (a != b) 1 else 0
              case 4 => if (a < b) 1 else 0
              case 6 => if (a < b) 1 else 0
              case 5 => if (a >= b) 1 else 0
              case 7 => if (a >= b) 1 else 0
              case _ => 0
            }

        c.io.arg_x.poke(a.U)
        c.io.arg_y.poke(b.U)
        c.io.fnct3.poke(funct3.U)
        c.io.branch.poke(branch.B)
        c.clock.step(1)
        if (branch) c.io.br_taken.expect(result.B)
        else c.io.br_taken.expect(0.B)




        println("----f----",funct3)
        println("----a----",a)
        println("----b----",b)
        println("----branch----",branch)
        println("----result----",result)
      



        // def br = if (branch) 1 else 0
        // def res = result > 0
        // if (branch & res) c.io.br_taken.expect(1.B)
        // else c.io.br_taken.expect(0.B)
        // if (branch) c.io.br_taken.expect(result.B)
          
        

      }
    }
  }
}