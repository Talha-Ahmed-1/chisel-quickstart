package lab4

import chisel3._
import chisel3.util._

class LM_IO_Interface_ImmdValGen extends Bundle {
    val instr = Input ( UInt (32. W ) )
    val immd_se = Output ( UInt (32. W ) )
    val pc = Input(UInt(32.W))
}
class task2 extends Module {
    val io = IO (new LM_IO_Interface_ImmdValGen )

    def opcode = io.instr(6,0)

    val s_imm13 = Cat(io.instr(31,25),io.instr(11,7))
    val sb_imm13 = Cat (io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8),"b0".U)
    val uj_imm21 = Cat (io.instr(31),io.instr(19,12),io.instr(20),io.instr(30,21),"b0".U)

    val s = Cat(Fill(20,s_imm13(11)),s_imm13)
    val sb = (Cat(Fill(19,sb_imm13(12)),sb_imm13)) + io.pc
    val uj = (Cat(Fill(12,uj_imm21(20)),uj_imm21)) + io.pc
    val u = (Cat(Fill(12,io.instr(31)),io.instr(31,12))) << 12
    val i = Cat(Fill(20,io.instr(31)),io.instr(31,20))

    io.immd_se := MuxCase(0.U,Array(
        // S
        (opcode === 35.U) -> s,
        // SB
        (opcode === 99.U) -> sb,
        // UJ
        (opcode === 111.U) -> uj,
        // U
        (opcode === 23.U) -> u,
        // I
        (opcode <= 19.U || opcode >= 3.U || opcode === 27.U || opcode === 115.U) -> i
    ))

}