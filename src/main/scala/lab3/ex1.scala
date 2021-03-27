package lab3

import chisel3._
import chisel3.util._
import util._

class ex1 extends Module{
    val io = IO(new encoderIO)

    val sel = Cat(io.in1, io.in2, io.in3, io.in4)
    io.out := 0.U
    switch (sel){
        is ("b1000".U){io.out := "b00".U}
        is ("b0100".U){io.out := "b01".U}
        is ("b0010".U){io.out := "b10".U}
        is ("b0001".U){io.out := "b11".U}

    }
}

class encoderIO extends Bundle{
    val in1 = Input(Bool())
    val in2 = Input(Bool())
    val in3 = Input(Bool())
    val in4 = Input(Bool())
    val out = Output(UInt(2.W))

}