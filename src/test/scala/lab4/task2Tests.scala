package lab4

import org.scalatest._
import chiseltest._
import chisel3._
import scala.util.Random

class task2Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 4 Task 2" in {
    test(new task2()) { c =>
      val inst_array = Array("h06310013","h08216013", "h03f17013","h05814013")
      for (i <- 0 until 100){
        val inst = inst_array(Random.nextInt(4))
        val result = inst match {
          case ("h06310013") => 99
          case ("h08216013") => 130
          case ("h03f17013") => 63
          case ("h05814013") => 88
        }
      println("---inst---",inst)
        c.io.instr.poke(inst.U)
        c.io.pc.poke(4.U)
        c.io.immd_se.expect(result.U)
      }

      // c.io.instr.poke(103838099.U)
      // c.io.instr.poke("h01700013".U)
      // c.io.pc.poke(1.U)
      // c.io.immd_se.expect(23.U)
    //   c.io.arg_x.poke(20.U)
    //   c.io.arg_y.poke(20.U)
    //   c.io.fnct3.poke("b000".U)
    //   c.io.branch.poke(1.B)
    //   c.io.br_taken.expect(1.B)

    }
  }
}
