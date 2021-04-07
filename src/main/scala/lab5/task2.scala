package lab5

import chisel3._
import chisel3.util._

class DataPacket[T<:Data](tipe:T) extends Bundle{
    val addr = UInt(10.W)
    val data = tipe
    override def cloneType = (new DataPacket(tipe)).asInstanceOf[this.type]
}

class task2[T<:Data](tipe:T, tipe1:T) extends Module{
    // val tipe1 = tipe
    val io = IO(new Bundle{
        val in = Input(new DataPacket(tipe))
        val out = Output(new DataPacket(tipe))
    })
    
    io.out <> io.in
}