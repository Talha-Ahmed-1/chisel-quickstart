package lab7

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum


case class UART_Params (
    dataBits : Int = 8 ,
    stopBits : Int = 2 ,
    divisorBits : Int = 5 ,
    oversample : Int = 2 ,
    nSamples : Int = 3 ,
    nTxEntries : Int = 4 ,
    nRxEntries : Int = 4) {
    def oversampleFactor = 1 << oversample
    require ( divisorBits > oversample )
    require ( oversampleFactor > nSamples )
}
class Practice ( c : UART_Params ) extends Module {
    val io = IO (new Bundle {
        val en = Input ( Bool () )
        val in = Flipped ( Decoupled ( UInt (( c. dataBits ) . W ) ) )
        val out = Output ( Bool () )
        val div = Input ( UInt (( c . divisorBits ) .W ) )
        val nstop = Input ( UInt (( c . stopBits ) . W ) )
    })
    // pulses generated at baud rate using prescaler
    val prescaler = RegInit (0. U (( c . divisorBits ) .W ) )
    val pulse = ( prescaler === 0. U )
    private val n = c . dataBits + 1
    val counter = RegInit (0. U (( log2Floor ( n + c . stopBits ) +1) . W ) )
    val shifter = Reg ( UInt ( n . W ) )
    val out = RegInit ( true . B )
    io . out := out
    val busy = ( counter =/= 0. U )
    val state1 = io . en && ! busy
    val state2 = busy
    io . in . ready := state1
    when ( state1 ) {
        shifter := Cat ( io . in . bits , false . B )
        counter := Mux1H (
        (0 until c . stopBits ).map ( i => ( io . nstop === i . U ) -> ( n + i +2) . U )
        )
    }
    when ( state2 ) {
        prescaler := Mux( pulse , ( io . div - 1. U ) , prescaler - 1. U )
        when ( pulse ) {
            counter := counter - (1. U )
            shifter := Cat ( true .B , shifter >> 1)
            out := shifter (0)
        }
    }
}
///////////////////////////////////////////////////////////////
// class Practice ( n : Int = 8) extends Module {
//     val io = IO (new Bundle {
//         val data_in = Input ( UInt ( n . W ) )
//         val out = Output ( Bool () )
//     })
//     val counter = RegInit (0. U ( n . W ) )
//     val max_count = RegInit (6. U ( n . W ) )
//     val init :: up :: down :: Nil = Enum (3) // Enumeration type
//     val state = RegInit ( init ) // state = init
//     val up_flag = ( counter === max_count )
//     val down_flag = ( counter === 0. U )
//     switch ( state ) {
//         is ( init ) {
//             state := up // on reset
//         }
//         is ( up ) {
//             when ( up_flag ) {
//                 state := down
//                 // start count down immediately on up_flag
//                 counter := counter - 1. U
//             } .otherwise {
//                 counter := counter + 1. U
//             }
//         }
//         is ( down ) {
//             when ( down_flag ) {
//                 state := up
//                 counter := counter + 1. U
//                 max_count := io . data_in // load the counter
//             } .otherwise {
//                 counter := counter - 1. U
//             }
//         }
//     }
//     io . out := up_flag | down_flag
// }
//////////////////////////////////////////////////
// class Practice extends Module {
//     val io = IO (new Bundle {
//         val in = Input ( Bool () )
//         val out = Output ( Bool () )
//     })
//     val s0 :: s1 :: s2 :: Nil = Enum (3) // Enumeration type
//     val state = RegInit ( s0 ) // state = s0
//     io . out := ( state === s2 ) & (! io . in ) // Mealy type state machine
//     switch ( state ) {
//         is ( s0 ) {
//             when ( io . in ) {
//             // move to next state when input is 1
//                 state := s1
//             }
//         }
//         is ( s1 ) {
//             when ( io . in ) {
//             // move to next state when input is 1
//             state := s2
//             } .otherwise {
//             state := s0
//             }
//         }
//         is ( s2 ) {
//             when (! io . in ) {
//             // move to default state when input is zero
//             // otherwise stay here because input sequence is 111
//             state := s0
//             }
//         }
//     }
// }
