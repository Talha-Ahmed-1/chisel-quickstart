package lab8

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum


class Practice extends Module {
    val width : Int = 8
    val io = IO (new Bundle {
        val enable = Input ( Bool () )
        val write = Input ( Bool () )
        val addr = Input ( UInt (10. W ) )
        val mask = Input ( Vec (4 , Bool () ) )
        val dataIn = Input ( Vec (4 , UInt ( width . W ) ) )
        val dataOut = Output ( Vec (4 , UInt ( width . W ) ) )
    })
    val mem = SyncReadMem (1024 , Vec (4 , UInt ( width . W ) ) )
    mem . write ( io . addr , io . dataIn , io . mask )
    io . dataOut := mem . read ( io . addr , io . enable )
}


// class Practice extends Module {
//     val io = IO (new Bundle {
//         val out = Output ( UInt (32. W ) )
//         val rdAddr = Input ( UInt (10. W ) )
//         val wrAddr = Input ( UInt (10. W ) )
//         val wrData = Input ( UInt (32. W ) )
//         val wr_en = Input ( Bool () )
//     })
//     val memory = SyncReadMem (1024 , UInt (32. W ) )
//     val wrDataReg = RegNext ( io . wrData )
//     val doForwardReg = RegNext ( io . wrAddr === io . rdAddr && io . wr_en )
//     val memData = memory . read ( io . rdAddr )
//     when ( io . wr_en ){
//         memory . write ( io . wrAddr , io . wrData )
//     }
//     io . out := Mux ( doForwardReg , wrDataReg , memData )
// }


// class Practice (val size : Int = 32 , val width : Int = 32) extends Module {
//     val io = IO (new Bundle {
//         val dataIn = Input ( UInt ( width . W ) )
//         val dataOut = Output ( UInt ( width . W ) )
//         val addr = Input ( UInt ( log2Ceil ( size ) . W ) )
//         val rd_enable = Input ( Bool () )
//         val wr_enable = Input ( Bool () )
// })
//     val Sync_memory = SyncReadMem ( size , UInt ( width . W ) )
//     when ( io . wr_enable ) {
//         Sync_memory . write ( io . addr , io . dataIn )
//     }
//     io . dataOut := Sync_memory . read ( io . addr , io . rd_enable )
// }


// class IO_Interface extends Bundle {
// // Make an input from a Vector of 4 values
//     val data_in = Input ( Vec (4 ,( UInt (32. W ) ) ) )
//     val data_selector = Input ( UInt (2. W ) )
//     val data_out = Output ( UInt (32. W ) )
//     val addr = Input ( UInt (5. W ) )
//     // The signal is high for write
//     val wr_en = Input ( Bool () )
// }
// class Practice extends Module {
//     val io = IO (new IO_Interface )
//     io . data_out := 0. U
//     // Make a memory of 32 x32
//     val memory = Mem (32 , UInt (32. W ) )
//     when ( io . wr_en ) {
//     // Write for wr_en = 1
//     // Write at memory location addr , with selected data from data_in
//         memory . write ( io . addr , io . data_in ( io . data_selector ) )
//     }
//     // Asyncronous read from addr location
//     io . data_out := memory . read ( io . addr )
// }