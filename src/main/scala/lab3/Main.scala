// package lab3

// import chisel3._
// import chisel3.util._
// import chisel3.stage.ChiselStage


// object Main extends App{
//     println("Main file of lab 3.")
//     println(ChiselStage.emitVerilog(new Valid_Interf))
// }

// class Valid_Interf extends Module {
//     val DataWithValid = Valid (new DataWithoutValid )
// }

// class DataWithoutValid extends Bundle {
//     val data_bits = Output ( UInt (8. W ) )
// }
// val DataWithValid = Valid (new DataWithoutValid )

// import chisel3 . _
// import chisel3 . util . _
// import chisel3.iotesters.{ChiselFlatSpec , Driver , PeekPokeTester}
// class Valid_Interf extends Module {
//     val io = IO ( new Bundle {
//     val in = Flipped ( Valid ( UInt (8. W ) ) ) // valid = Input , bits = Input
//     val out = Valid ( UInt (8. W ) ) // valid = Output , bits = Output
//     })
//     io . out := RegNext ( io . in )
// }
// println ( chisel3 . Driver . emitVerilog (new Valid_Interf ) )


















// class LM_IO_Interface extends Bundle {
//     val in = Input ( UInt (2. W ) )
//     val out = Output ( UInt (4. W ) )
// }
// class Decoder_2to4 extends Module {
//     val io = IO (new LM_IO_Interface )
//     when ( io . in === "b00 ". U ) {
//         io . out := " b0001 ". U
//     // } .elsewhen ( io . in === "b01". U ) {
//     //     io . out := " b0010 ". U
//     // } .elsewhen ( io . in === "b10". U ) {
//     //     io .    out := " b0100 ". U
//     // } .otherwise {
//     //     io . out := " b1000 ". U
//     }
// }

// // class task extends Module{
// //     val io = IO(new Bundle{
// //     val in = Input(Bool())
// //     val out = Output(Bool())
// //     })
// //     val s1 = WireInit(true.B)
// //     s1 := false.B
// //     io.out := s1
// // }

