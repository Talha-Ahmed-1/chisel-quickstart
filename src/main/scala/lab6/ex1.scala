package lab6

import chisel3._
import chisel3.util._



class ex1 ( val init : Int = 1) extends Module {
    val io = IO (new Bundle {
        val in = Input(UInt(4.W))
        val out = Output(Bool())
    })
    // io.out := 0.B
    val state = RegInit(0.U(4.W))
    state := io.in
    


    // state := state >> 1
    // io.out := state(3)
    // val flag = RegInit(0.U(4.W))
    // when (flag < 4.U){
    //     state := state >> 1
    //     io.out := state(3)
    // //     state := state >> 1
    //     flag := flag + 1.U
    //     }
    



//     val state = RegInit ( init . U (4. W ) ) // register initialization
//     // serial data in at LSB
//     val nextState = ( state << 1) | io . in
//     state := nextState
//     io . out := state
}


// class ex1 ( val init : Int = 1) extends Module {
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