package lab6

import chisel3._
import chisel3.util._

class Practice (val max : Int , val min : Int = 0) extends Module {
    val io = IO (new Bundle {
        val out = Output ( UInt ( log2Ceil ( max ) . W ) )
    })
    val counter = RegInit ( min . U ( log2Ceil ( max ) . W ) )
    // If the max count is of power 2 and the min value = 0 ,
    // then we can skip the comparator and the Mux
    val count_buffer = if ( isPow2 ( max ) && ( min == 0) ) counter + 1. U
    else Mux ( counter === max .U , min .U , counter + 1. U )
    counter := count_buffer
    io . out := counter
}





// class Practice ( val init : Int = 1) extends Module {
//     val io = IO (new Bundle {
//         val in = Input ( Bool () )
//         val out = Output ( UInt (4. W ) )
//     })
//     val state = RegInit ( init . U (4. W ) ) // register initialization
//     // serial data in at LSB
//     val nextState = ( state << 1) | io . in
//     state := nextState
//     io . out := state
// }