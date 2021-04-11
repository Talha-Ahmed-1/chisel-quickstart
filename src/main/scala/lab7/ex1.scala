package lab7

import chisel3._
import chisel3.util._

class ex1 extends Module{
    val io = IO(new ex1_IO)
    val q1 = Queue(io.in1)
    val q2 = Queue(io.in2)

    val arbiter = Module(new Arbiter(UInt(),2))
    arbiter.io.in(0) <> q1
    arbiter.io.in(1) <> q2

    io.out <> arbiter.io.out
}

class ex1_IO extends Bundle{
    val in1 = Flipped(Decoupled(UInt(32.W)))
    val in2 = Flipped(Decoupled(UInt(32.W)))
    val out = Decoupled(UInt(32.W))
}