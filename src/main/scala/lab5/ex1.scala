package lab5

import chisel3 . _
import chisel3 . util . _

class IOs ( width : Int ) extends Bundle {
    val alu_oper = Input ( UInt ( width . W ) )
    val arg_x = Input ( UInt ( width . W ) )
    val arg_y = Input ( UInt ( width . W ) )
    val alu_out = Output ( UInt ( width . W ) )
}

class ex1 ( width_parameter : Int ) extends Module {
    val io = IO (new IOs ( width_parameter ) )
    // io . alu_out := 0. U
    val index = log2Ceil ( width_parameter )
        when(io.alu_oper === 0.U){io . alu_out := io . arg_x & io . arg_y}
        .elsewhen(io.alu_oper === 1.U){io . alu_out := io . arg_x | io . arg_y}
        .elsewhen(io.alu_oper === 2.U){io . alu_out := io . arg_x + io . arg_y}
        .elsewhen(io.alu_oper === 6.U){io . alu_out := io . arg_x - io . arg_y}
        .elsewhen(io.alu_oper === 3.U){io . alu_out := io . arg_x ^ io . arg_y}
        .elsewhen(io.alu_oper === 4.U){io . alu_out := io . arg_x << io . arg_y ( index -1 , 0)}
        .elsewhen(io.alu_oper === 5.U){io . alu_out := io . arg_x >> io . arg_y ( index -1 , 0)}
        .elsewhen(io.alu_oper === 7.U){io . alu_out := ( io . arg_x . asSInt >> io . arg_y ( index -1 , 0) ) . asUInt}
        .elsewhen(io.alu_oper === 8.U){io . alu_out := io . arg_x . asSInt < io . arg_y . asSInt}
        .elsewhen(io.alu_oper === 9.U){io . alu_out := io . arg_x < io . arg_y}
        .otherwise{io . alu_out := 0.U}
}
















    // switch ( io . alu_oper ) { // AND
        //     is("b0000". U ) {
        //     io . alu_out := io . arg_x & io . arg_y
        // } // OR
        // is("b0001". U ) {
        //     io . alu_out := io . arg_x | io . arg_y
        // } // ADD
        // is("b0010". U ) {
        //     io . alu_out := io . arg_x + io . arg_y
        // } // SUB
        // is("b0110". U ) {
        //     io . alu_out := io . arg_x - io . arg_y
        // } // XOR
        // is("b0011". U ) {
        //     io . alu_out := io . arg_x ^ io . arg_y
        // } // SLL
        // is("b0100". U ) {
        //     io . alu_out := io . arg_x << io . arg_y ( index -1 , 0)
        // } // SRL
        // is("b0101". U ) {
        //     io . alu_out := io . arg_x >> io . arg_y ( index -1 , 0)
        // } // SRA
        // is("b0111". U ) {
        //     io . alu_out := ( io . arg_x . asSInt >> io . arg_y ( index -1 , 0) ) . asUInt
        // } // SLT
        // is("b1000". U ) {
        //     io . alu_out := io . arg_x . asSInt < io . arg_y . asSInt
        // } // SLTU
        // is("b1001". U ) {
        //     io . alu_out := io . arg_x < io . arg_y
        // }
    // }