package lab5

import chisel3 . _
import chisel3 . util . _

class MuxBundle [T<:Data](gen:T) extends Bundle{
    val out = Output ( gen )
    val in1 = Input ( gen )
    val in2 = Input ( gen )
    val sel = Input ( Bool () )   
}

class ex2[T<:Data](size : T) extends Module{
    val io = IO(new MuxBundle(size))
    io.out := Mux( io.sel , io.in2 , io.in1 )
}