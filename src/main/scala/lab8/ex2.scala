package lab8

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum


class ex2 extends Module {
    val width : Int = 16
    val io = IO (new Bundle {
        val enable = Input ( Bool () )
        val write = Input ( Bool () )
        val addr = Input ( UInt (10. W ) )
        val mask = Input ( Vec (2 , Bool () ) )
        val dataIn = Input ( Vec (2 , UInt ( width . W ) ) )
        val dataOut = Output ( Vec (2 , UInt ( width . W ) ) )
    })
    val mem = SyncReadMem(1024,Vec(2,UInt(width.W)))
    val wrReg = RegNext(io.dataIn)
    val memData = mem.read(io.addr)
    val selReg = RegNext(io.enable === true.B && io.write === true.B)

    when(io.write){
        mem.write(io.addr, io.dataIn, io.mask)
    }

    when(selReg){
        for (i <- 0 until 2){
            io.dataOut(i) := Mux(selReg, Mux(io.mask(i), wrReg(i), 0.U), 0.U)
        }
    }.otherwise(io.dataOut := memData)












    // when(selReg){
    //     io.dataOut(0) := Mux(io.mask(0), wrReg(0), 0.U) 
    //     io.dataOut(1) := Mux(io.mask(1), wrReg(1), 0.U) 
    //     io.dataOut(2) := Mux(io.mask(2), wrReg(2), 0.U) 
    //     io.dataOut(3) := Mux(io.mask(3), wrReg(3), 0.U) 

        // MuxCase(false.B, Array(
        //     (io.mask(0) === true.B) -> io.dataOut(0) := wrReg(0),
        //     (io.mask(1) === true.B) -> io.dataOut(1) := wrReg(1),
        //     (io.mask(2) === true.B) -> io.dataOut(2) := wrReg(2),
        //     (io.mask(3) === true.B) -> io.dataOut(3) := wrReg(3)
        // ))
    // }.otherwise{io.dataOut := mem.read(io.addr, io.enable)}

    // io.dataOut := Mux(selReg, wrReg, memData)

}