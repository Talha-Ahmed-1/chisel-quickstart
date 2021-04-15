package lab7

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum

class task2 extends Module {
    val io = IO (new Bundle {
        val in = Input ( UInt (1. W ) )
        val start = Input ( Bool () )
        val out = Output ( UInt (8. W ) )
        val flag = Output ( UInt (1. W ) )
    })

    val off :: on :: Nil = Enum(2)
    val outReg = RegInit(0.U(8.W))
    val state = RegInit(off)

    io.flag := 0.B
    io.out := outReg

    switch(state){
        is(off){
            io.flag := 0.B
            io.out := outReg
            when(io.start){state := on}
        }
        is(on){
            outReg := outReg << 1 | io.in
            io.out := outReg
            io.flag := 1.B
            when(!io.start){state := off}
        }
    }
}



    
    // switch(io.start){
    //     is(off.asBool){
    //         io.out := 0.U
    //         io.flag := 0.U
    //     }
    //     is(on.asBool){
    //         outReg := outReg << 1 | io.in
    //         io.out := outReg
    //         io.flag := 1.U
    //     }


    // val off :: on :: Nil = Enum(2)
    // val outReg = RegInit(0.U(8.W))
    // io.flag := 0.B
    // io.out := outReg

    // switch(io.start){
    //     is(off.asBool){
    //         io.out := 0.U
    //         io.flag := 0.U
    //     }
    //     is(on.asBool){
    //         outReg := outReg << 1 | io.in
    //         io.out := outReg
    //         io.flag := 1.U
    //     }
//     }