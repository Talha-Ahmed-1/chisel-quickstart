package labs

import chisel3._
import chisel3.util._

object Main extends App{
    println("-----------------------")
    class Counter ( counterBits : UInt ) extends Module {
        val io = IO ( new Bundle {
          val result = Output ( Bool () )
        })

        val max = (1. U << counterBits ) - 1. U
        val count = RegInit (0. U (16. W ) )
        when ( count === max ) {
            count := 0. U
        } .otherwise {
            count := count + 1. U
        }
        io . result := count (15. U )
        println ( s" counter created with max value $max " )
        }
}