package lab4

import org.scalatest._
import chiseltest._
import chisel3._

class task2Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 4 Task 2" in {
    test(new task2()) { c =>
      // c.io.instr.poke(103838099.U)
      // c.io.instr.poke("h01700013".U)
      // c.io.pc.poke(1.U)
      // c.io.immd_se.expect(23.U)
    //   c.io.arg_x.poke(20.U)
    //   c.io.arg_y.poke(20.U)
    //   c.io.fnct3.poke("b000".U)
    //   c.io.branch.poke(1.B)
    //   c.io.br_taken.expect(1.B)

      // def opcode = io.instr(6,0)

      // val s_imm13 = Cat(io.instr(31,25),io.instr(11,7))
      // val sb_imm13 = Cat (io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8),"b0".U)
      // val uj_imm21 = Cat (io.instr(31),io.instr(19,12),io.instr(20),io.instr(30,21),"b0".U)

      // val s = Cat(Fill(20,s_imm13(11)),s_imm13)
      // val sb = (Cat(Fill(19,sb_imm13(12)),sb_imm13)) + io.pc
      // val uj = (Cat(Fill(12,uj_imm21(20)),uj_imm21)) + io.pc
      // val u = (Cat(Fill(12,io.instr(31)),io.instr(31,12))) << 12
      // val i = Cat(Fill(20,io.instr(31)),io.instr(31,20))










    }
  }
}
