package lab8

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum
import chisel3.util.experimental.loadMemoryFromFile

class INST_IO extends Bundle{
    val addr = Input(UInt(32.W))
    val write = Input(Bool())
    val instR = Output(UInt(32.W))
    val instW = Input(UInt(32.W))
}

class ex3 extends Module{
    val io = IO(new INST_IO)
    val i_mem = Mem(32, UInt(32.W))

    when (io.write === true.B){
        i_mem.write(io.addr, io.instW)
    }

    // loadMemoryFromFile(i_mem, "/home/talha/inst.txt")
    io.instR := i_mem(io.addr)
}