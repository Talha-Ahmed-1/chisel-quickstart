package labs

import chisel3._
import chisel3.util._
import chisel3.stage.ChiselStage

    
class task extends Module{
    val io = IO(new Bundle{
    val in = Input(Bool())
    val out = Output(Bool())
    })
    val s1 = WireInit(true.B)
    s1 := false.B
    io.out := s1
}

object Main extends App{
println(ChiselStage.emitVerilog(new task))
}