package lab6

import chisel3._
import chisel3.util._

class ex4 extends Module {
    val io = IO ( new Bundle {
       val in = Flipped(Decoupled(UInt(8.W)))
       val out = Decoupled(UInt(8.W))
       })

    val firstQueue = Queue(io.in, 5)
    val secondQueue = Queue(firstQueue,5)
    io.out <> secondQueue

    // io.out <> Queue(Queue(io.in,5),5)



//     val firstQueue = Module(new Queue(UInt(), 5))
//     val secondQueue = Module(new Queue(UInt(), 5))


//     // when(io.in.valid){
//     //     firstQueue.io.enq <> io.in
//     // // }.elsewhen(io.in.valid){
//     //     secondQueue.io.enq <> firstQueue.io.deq
//     // }.elsewhen(io.out.ready){
//     //     io.out <> secondQueue.io.deq
//     // }.otherwise{io.out.bits := 0.U}

//     firstQueue.io.enq <> io.in
//     // secondQueue.io.enq <> firstQueue.io.deq
//     // io.out <> firstQueue.io.deq 
//     io.out.bits := 0.U
}