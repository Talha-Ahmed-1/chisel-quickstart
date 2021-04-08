package lab6

import chisel3._
import chisel3.util._

class task2 ( val max : Int = 10) extends Module {
    val io = IO (new Bundle {
        val out = Output(UInt((log2Ceil(max).W)))
    })
    val n = log2Ceil(max)
    val count = RegInit(0.U(n.W))

    when ((count(n-1).asBool ^ false.B).asBool) {
        count := 0.U
    }.otherwise {
        count := count + 1.U
    }
    io.out := count

}