package lab6

import chisel3._
import chisel3.util._

class task4 ( val max : Int = 10) extends Module {
    val io = IO (new Bundle {
        val out = Output ( UInt ( log2Ceil ( max ) . W ) )
        val up_down = Input (Bool())
    })
    val n = log2Ceil(max)
    val count = RegInit(0.U(n.W))

    when(io.up_down === 1.B && count =/= max.U){
        count := count + 1.U
    }.elsewhen(io.up_down === 0.U && count =/= 0.U){
        count := count - 1.U
    }

    io.out := count
}