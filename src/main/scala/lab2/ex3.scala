package lab2

import chisel3._
import chisel3.util._

class ex3 extends Module{
    val io = IO(new encoderIO)

    val sel = Cat(io.in1, io.in2, io.in3, io.in4)
    io.out1 := Mux1H(sel, Seq("b00".U, "b01".U, "b10".U, "b11".U))

    // val sel2 = Cat(io.in3, io.in4)

    // val sel = Cat(sel1,sel2)

    // io.out1 := Mux1H(sel1, Seq(0.B, 1.B))
    // io.out2 := Mux1H(sel2,Seq(0.B, 1.B))
}

class encoderIO extends Bundle{
    val in1 = Input(Bool())
    val in2 = Input(Bool())
    val in3 = Input(Bool())
    val in4 = Input(Bool())
    val out1 = Output(UInt(2.W))

}
