package lab6

import chisel3._
import chisel3.util._

object Main extends App{
    println((new chisel3.stage.ChiselStage).emitVerilog(new shift_register))
}


class shift_register ( val init : Int = 1) extends Module {
    val io = IO (new Bundle {
        val in = Input ( Bool () )
        val out = Output ( UInt (4. W ) )
    })
    val state = RegInit ( init . U (4. W ) ) // register initialization
    // serial data in at LSB
    val nextState = ( state << 1) | io . in
    state := nextState
    io . out := state
}

///////////////////////////////////////////////////
class RegPractice extends Module{
    val io = IO(new Bundle{
        val in = Input(UInt(32.W))
        val out = Output(UInt(32.W))
    })
    // val reg = Reg(UInt(32.W))
    // io.out := reg(io.in)

    // val reg = RegInit(18.U(32.W))
    // io.out := reg(io.in)

    // val reg = Reg(UInt(8.W))
    // val reg1 = RegInit(reg)

    // io.out := RegNext(io.in)

    // val reg = RegEnable(1.U, io.in, false.B)
    // io.out := reg

}