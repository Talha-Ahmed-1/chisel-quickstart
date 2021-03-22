package lab2

import chisel3 . _
import chisel3.util._


class LM_IO_Interface extends Bundle {
    val s0 = Input(Bool())
    val s1 = Input(Bool())
    val s2 = Input(Bool())
    val out = Output(UInt(32.W))
}
class task1 extends Module {
val io = IO ( new LM_IO_Interface )

val sel = Cat(io.s2, io.s1, io.s0)
// io.out := Mux1H(sel, Seq(0.U, 8.U, 16.U, 24.U, 32.U, 32.U, 32.U, 32.U))
// Start coding here
// End your code here

io.out := MuxCase(32.U, Array(
    (sel === 0.U) -> 0.U,
    (sel === 1.U) -> 8.U,
    (sel === 2.U) -> 16.U,
    (sel === 3.U) -> 24.U
))
}