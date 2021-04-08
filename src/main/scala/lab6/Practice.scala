package lab6

import chisel3._
import chisel3.util._





class Practice extends Module {
    val io = IO ( new Bundle {
        val in = Flipped ( Decoupled ( UInt (8. W ) ) ) // valid = Input , ready =
        val out = Decoupled ( UInt (8. W ) ) // valid = Output , ready =
    })
    val queue = Queue ( io . in , 5) // 5 - element queue
    
    io . out <> queue
}



// class Practice extends Module {
//     val io = IO ( new Bundle {
//         val in = Flipped ( Valid ( UInt (8. W ) ) ) // valid = Input , bits = Input
//         val out = Valid ( UInt (8. W ) ) // valid = Output , bits = Output
//     })
//     io . out := Pipe ( io.in ,5)
// }




// trait Config{
//     val XLEN = 32
//     val REGFILE_LEN = 32
// }
// class RegFileIO extends Bundle with Config {
// val raddr1 = Input ( UInt (5. W ) )
// val raddr2 = Input ( UInt (5. W ) )
// val rdata1 = Output ( UInt ( XLEN . W ) )
// val rdata2 = Output ( UInt ( XLEN . W ) )
// val wen = Input ( Bool () )
// val waddr = Input ( UInt (5. W ) )
// val wdata = Input ( UInt ( XLEN . W ) )
// }
// class Practice extends Module with Config {
//     val io = IO (new RegFileIO )
//     val regs = Reg ( Vec ( REGFILE_LEN , UInt ( XLEN . W ) ) )
//     io . rdata1 := Mux (( io . raddr1 . orR ) , regs ( io . raddr1 ) , 0. U )
//     io . rdata2 := Mux (( io . raddr2 . orR ) , regs ( io . raddr2 ) , 0. U )
//     when ( io . wen & io . waddr . orR ) {
//         regs ( io . waddr ) := io . wdata
//     }
// }

// class Practice (val max : Int = 2 , val duty_cycle : Int = 1) extends Module {
//     val io = IO (new Bundle {
//         val out = Output ( Bool () )
// })
//     val counter = RegInit (0. U ( log2Ceil ( max ) . W ) )
//     counter := Mux ( counter === max .U , 0. U , counter +1. U )
//     io . out := duty_cycle . U > counter
// }



// class Practice (val max : Int , val min : Int = 0) extends Module {
//     val io = IO (new Bundle {
//         val out = Output ( UInt ( log2Ceil ( max ) . W ) )
//     })
//     val counter = RegInit ( min . U ( log2Ceil ( max ) . W ) )
//     // If the max count is of power 2 and the min value = 0 ,
//     // then we can skip the comparator and the Mux
//     val count_buffer = if ( isPow2 ( max ) && ( min == 0) ) counter + 1. U
//     else Mux ( counter === max .U , min .U , counter + 1. U )
//     counter := count_buffer
//     io . out := counter
// }





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