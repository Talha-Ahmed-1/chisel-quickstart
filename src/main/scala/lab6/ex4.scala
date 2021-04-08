package lab6

import chisel3._
import chisel3.util._

class ex4 extends Module {
    val io = IO ( new Bundle {
       val in = Flipped(Decoupled(UInt(8.W)))
       val out = Decoupled(UInt(8.W))
       })

    val firstQueue = Queue(io.in,5)
    val secondQueue = Queue(firstQueue,5)

    firstQueue.nodeq()
    secondQueue.nodeq()
    when(secondQueue.valid && io.out.ready){
        io.out.enq(secondQueue.deq())
    }.otherwise{
        io.out.bits := 0.U
        io.out.valid := 0.B
    }

}