package lab8

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum


class ex1 extends Module {
    val width : Int = 8
    val io = IO (new Bundle {
        val enable = Input ( Bool () )
        val write = Input ( Bool () )
        val addr = Input ( UInt (10. W ) )
        val mask = Input ( Vec (4 , Bool () ) )
        val dataIn = Input ( Vec (4 , UInt ( width . W ) ) )
        val dataOut = Output ( Vec (4 , UInt ( width . W ) ) )
    })
    val mem = SyncReadMem(1024,Vec(4,UInt(width.W)))

    when(io.write === true.B){
        val cc = Cat(io.mask(3),io.mask(2),io.mask(1),io.mask(0))
        when(cc === 0.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := 0.U
            vv(1) := 0.U
            vv(2) := 0.U
            vv(3) := 0.U
            mem.write(io.addr, vv)
        }.elsewhen(cc === 1.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := io.dataIn(0)
            vv(1) := 0.U
            vv(2) := 0.U
            vv(3) := 0.U
            mem.write(io.addr, vv)
        }.elsewhen(cc === 2.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := 0.U
            vv(1) := io.dataIn(1)
            vv(2) := 0.U
            vv(3) := 0.U
            mem.write(io.addr, vv)
        }.elsewhen(cc === 3.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := io.dataIn(0)
            vv(1) := io.dataIn(1)
            vv(2) := 0.U
            vv(3) := 0.U
            mem.write(io.addr, vv)
        }.elsewhen(cc === 4.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := 0.U
            vv(1) := 0.U
            vv(2) := io.dataIn(2)
            vv(3) := 0.U
            mem.write(io.addr, vv)
        }.elsewhen(cc === 5.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := io.dataIn(0)
            vv(1) := 0.U
            vv(2) := io.dataIn(2)
            vv(3) := 0.U
            mem.write(io.addr, vv)
        }.elsewhen(cc === 6.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := 0.U
            vv(1) := io.dataIn(1)
            vv(2) := io.dataIn(2)
            vv(3) := 0.U
            mem.write(io.addr, vv)
        }.elsewhen(cc === 7.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := io.dataIn(0)
            vv(1) := io.dataIn(1)
            vv(2) := io.dataIn(2)
            vv(3) := 0.U
            mem.write(io.addr, vv)
        }.elsewhen(cc === 8.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := 0.U
            vv(1) := 0.U
            vv(2) := 0.U
            vv(3) := io.dataIn(3)
            mem.write(io.addr, vv)
        }.elsewhen(cc === 9.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := io.dataIn(0)
            vv(1) := 0.U
            vv(2) := 0.U
            vv(3) := io.dataIn(3)
            mem.write(io.addr, vv)
        }.elsewhen(cc === 10.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := 0.U
            vv(1) := io.dataIn(1)
            vv(2) := 0.U
            vv(3) := io.dataIn(3)
            mem.write(io.addr, vv)
        }.elsewhen(cc === 11.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := 0.U
            vv(1) := io.dataIn(1)
            vv(2) := io.dataIn(2)
            vv(3) := io.dataIn(3)
            mem.write(io.addr, vv)
        }.elsewhen(cc === 12.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := 0.U
            vv(1) := 0.U
            vv(2) := io.dataIn(2)
            vv(3) := io.dataIn(3)
            mem.write(io.addr, vv)
        }.elsewhen(cc === 13.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := io.dataIn(0)
            vv(1) := 0.U
            vv(2) := io.dataIn(2)
            vv(3) := io.dataIn(3)
            mem.write(io.addr, vv)
        }.elsewhen(cc === 14.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := 0.U
            vv(1) := io.dataIn(1)
            vv(2) := io.dataIn(2)
            vv(3) := io.dataIn(3)
            mem.write(io.addr, vv)
        }.elsewhen(cc === 15.U){
            val vv = Reg(Vec(4, UInt()))
            vv(0) := io.dataIn(0)
            vv(1) := io.dataIn(1)
            vv(2) := io.dataIn(2)
            vv(3) := io.dataIn(3)
            mem.write(io.addr, vv)
        }

    }

    io.dataOut := mem.read(io.addr,io.enable)
}




// when(cc === 8.U){
        //     val vv = Reg(Vec(4, UInt()))
        //     vv(0) := io.dataIn(0)
        //     vv(1) := 0.U
        //     vv(2) := 0.U
        //     vv(3) := 0.U
        //     mem.write(io.addr, vv)
        // }.elsewhen(io.mask(1)){
        //     val vv = Reg(Vec(4, UInt()))
        //     vv(0) := 0.U
        //     vv(1) := io.dataIn(1)
        //     vv(2) := 0.U
        //     vv(3) := 0.U
        //     mem.write(io.addr, vv)
        // }.elsewhen(io.mask(2)){
        //     val vv = Reg(Vec(4, UInt()))
        //     vv(0) := 0.U
        //     vv(1) := 0.U
        //     vv(2) := io.dataIn(2)
        //     vv(3) := 0.U
        //     mem.write(io.addr, vv)
        // }.elsewhen(io.mask(3)){
        //     val vv = Reg(Vec(4, UInt()))
        //     vv(0) := 0.U
        //     vv(1) := 0.U
        //     vv(2) := 0.U
        //     vv(3) := io.dataIn(3)
        //     mem.write(io.addr, vv)
        // }