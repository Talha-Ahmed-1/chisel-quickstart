package lab6

import chisel3._
import chisel3.util._

object Main extends App{
    // val BBAdder = Module(new BlackBoxAdder)
    // println((new chisel3.stage.ChiselStage).emitVerilog(BBAdder))
}





class BlackBoxAdder extends BlackBox with HasBlackBoxInline {
    val io = IO (new Bundle () {
        val in1 = Input ( UInt (32. W ) )
        val in2 = Input ( UInt (32. W ) )
        val out = Output ( UInt (33. W ) )
    })
    setInline ("BlackBoxAdder.v",
    s"""
    | module BlackBoxAdder (
    | input [32:0] in1 ,
    | input [32:0] in2 ,
    | output [33:0] out
    |);
    | always @* begin
    | out <= (( in1) + (in2));
    |end
    | endmodule
    """. stripMargin )
}


////////////////////////////////////////////////////
class My_Queue extends Module {
    val io = IO ( new Bundle {
        val in = Flipped ( Decoupled ( UInt (8. W ) ) ) // valid = Input , ready =
        val out = Decoupled ( UInt (8. W ) ) // valid = Output , ready =
    })
    val queue = Queue ( io . in , 5) // 5 - element queue
    
    io . out <> queue
}


/////////////////////////////////////////////////
class Pipe extends Module {
    val io = IO ( new Bundle {
        val in = Flipped ( Valid ( UInt (8. W ) ) ) // valid = Input , bits = Input
        val out = Valid ( UInt (8. W ) ) // valid = Output , bits = Output
    })
    io . out := Pipe ( io.in ,5)
}

/////////////////////////////////////////////////////////////
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