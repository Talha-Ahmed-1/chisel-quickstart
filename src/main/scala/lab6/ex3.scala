package lab6

import chisel3._
import chisel3.util._
import chisel3.core



class ex3 (maxValue:Int) extends Module {
    val io = IO ( new Bundle {
    val out = Output(Bool())
    })
    val n = log2Ceil(maxValue)
    val timer1 = RegInit(maxValue.U(n.W))
    val timer2 = RegInit(maxValue.U(n.W))

    when ( (timer2 === maxValue.U || timer1 =/= maxValue.U) && timer1 =/= 0.U) {
        timer1 := timer1 - 1.U
        timer2 := timer2 - 1.U
        io.out := 0.B
    }.otherwise {
        // timer1 := maxValue.U
        // timer2 := maxValue.U
        io.out := 1.B
    }

}