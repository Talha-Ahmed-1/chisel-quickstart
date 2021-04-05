package lab5

import chisel3 . _
import chisel3 . util . _
import chisel3 . _
import chisel3 . util . _

object Main extends App{
    println (( new chisel3 . stage . ChiselStage ) . emitVerilog (new Router(UInt(16.W), UInt(16.W)) ))
    // println((new chisel3.stage.ChiselStage).emitVerilog(new Operator(4,UInt(16.W))(_&_)))
}





///////////////////////////////////////////////////////////////////////////


class Data1Packet[T<:Data](tipe:T) extends Bundle{
    val addr = UInt(10.W)
    val data = tipe
    override def cloneType = (new Data1Packet(tipe)).asInstanceOf[this.type]
}

class Router[T<:Data](tipe:T, tipe1:T) extends Module{
    val io = IO(new Bundle{
        val in = Input(new Data1Packet(tipe))
        val out = Output(new Data1Packet(tipe1))
    })
    
    io.out <> io.in



    // override def cloneType = ( new RouterInterface (tipe ) ) . asInstanceOf [ this . type ]

}

////////////////////////////////////////////////////////////////////////////////
class Operator [ T <: Data ]( n : Int , generic : T ) ( op : (T , T ) => T ) extends Module {
    require ( n > 0) // " reduce only works on non - empty Vecs "
    val io = IO (new Bundle {
        val in = Input ( Vec (n , generic ) )
        val out = Output ( generic )
    })

    io.out := io.in.reduce( op )
}

///////////////////////////////////////////////////////////////////////////////
class IO_Interface1 [ T <: Data ] ( data_type : T ) extends Bundle {
    val in1 = Input ( data_type . cloneType )
    val in2 = Input ( data_type . cloneType )
    val out = Output ( data_type . cloneType )
    val sel = Input ( Bool () )
}
class Adder ( size : UInt ) extends Module {
    val io = IO (new IO_Interface1 ( size ) )
    io . out := io . in1 + io . in2
}

//////////////////////////////////////////////////////////////////////////////
class switch_2cross2 [ T <: Data ]( parameter : T ) extends Module {
val io = IO (new Bundle {
    val in1 = Input ( parameter )
    val in2 = Input ( parameter )
    val out1 = Output ( parameter )
    val out2 = Output ( parameter )
    val sel = Input ( Bool () )
})
    when ( io . sel ) {
        io . out1 := io . in2
        io . out2 := io . in1
    }
    .otherwise {
        io . out1 := io . in1
        io . out2 := io . in2
    }
}

//////////////////////////////////////////////////////////////////////////////
class eMux [ T <: Data ]( gen : T ) extends Module {
    val io = IO (new Bundle {
    val out = Output ( gen )
    val in1 = Input ( gen )
    val in2 = Input ( gen )
    val sel = Input ( Bool () )
})
    io . out := Mux2_to_1 ( io . in2 , io . in1 , io . sel )
    def Mux2_to_1 [ T <: Data ]( in_0 :T , in_1 :T , sel : Bool ) : T = {
        Mux( sel , in_1 , in_0 )
        }
}

//////////////////////////////////////////////////////////////////////////////
class interface ( width : Int ) extends Bundle {
    val alu_oper = Input ( UInt ( width . W ) )
    val arg_x = Input ( UInt ( width . W ) )
    val arg_y = Input ( UInt ( width . W ) )
    val alu_out = Output ( UInt ( width . W ) )
}

class ALU ( width_parameter : Int ) extends Module {
    val io = IO (new interface ( width_parameter ) )
    io . alu_out := 0. U
    val index = log2Ceil ( width_parameter )
    switch ( io . alu_oper ) { // AND
        is("b0000". U ) {
            io . alu_out := io . arg_x & io . arg_y
        } // OR
        is("b0001". U ) {
            io . alu_out := io . arg_x | io . arg_y
        } // ADD
        is("b0010". U ) {
            io . alu_out := io . arg_x + io . arg_y
        } // SUB
        is("b0110". U ) {
            io . alu_out := io . arg_x - io . arg_y
        } // XOR
        is("b0011". U ) {
            io . alu_out := io . arg_x ^ io . arg_y
        } // SLL
        is("b0100". U ) {
            io . alu_out := io . arg_x << io . arg_y ( index -1 , 0)
        } // SRL
        is("b0101". U ) {
            io . alu_out := io . arg_x >> io . arg_y ( index -1 , 0)
        } // SRA
        is("b0111". U ) {
            io . alu_out := ( io . arg_x . asSInt >> io . arg_y ( index -1 , 0) ) . asUInt
        } // SLT
        is("b1000". U ) {
            io . alu_out := io . arg_x . asSInt < io . arg_y . asSInt
        } // SLTU
        is("b1001". U ) {
            io . alu_out := io . arg_x < io . arg_y
        }
    }
}
