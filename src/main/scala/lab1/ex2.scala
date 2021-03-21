package lab1

import chisel3._
import chisel3.util._
import chisel3.core


class ex2 ( counterBits : UInt ) extends Module {
    val io = IO ( new Bundle {
        val result = Output ( Bool () )
        val oo = Output(Bool())
        val aa = Output(SInt())
    })

    val max = (1. U << counterBits ) - 1. U
    val count = RegInit (0.S (4. W ) )
    count := 15.S
    when ( count === max.asSInt ) {
        count := 0. S
    }.elsewhen ( count(3.U) === 0.B ) {
        count := 15.S
    }.otherwise {
        count := count + 1. S
    }
    io.aa := count
    io . result := count(3.U)
    println ( s" counter created with max value $max " )
    val abc = RegInit(2.U(2.W))
    abc := 2.U
    io.oo := abc(1)
    // println(abc(31) === 0.U)
}


// package lab1

// import chisel3._
// import chisel3.util._
// import chisel3.core


// class ex1 ( counterBits : UInt ) extends Module {
//     val io = IO ( new Bundle {
//         val result = Output ( Bool () )
//     })

//     val max = (1. U << counterBits ) - 1. U
//     val count = RegInit (0.S (16. W ) )
//     when ( count === max.asSInt ) {
//         count := 0. S
//     } .elsewhen(count(15.U) === 0.B){
//         count := 1.S
//     }.otherwise {
//         count := count + 1.S
//     }
//     io . result := count(15.U)
//     println ( s" counter created with max value $max " )
// }