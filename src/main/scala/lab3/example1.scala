package lab3

import chisel3._
import chisel3.util._

class LM_IO_Interface extends Bundle {
    val in = Input ( UInt (2. W ) )
    val out = Output ( UInt (4. W ) )
}
class Decoder_2to4 extends Module {
    val io = IO(new LM_IO_Interface )

    io.out := io.in
    when (io.in === "b00".U){io.out := 1.U}
    .elsewhen (io.in === "b01".U){io.out := 2.U}
    .elsewhen (io.in === "b10".U){io.out := 4.U}
    .otherwise {io.out := 8.U}
}
// --------------------------------------

class EncoderIO extends Bundle {
    val in = Input ( UInt (4. W ) )
    val out = Output ( UInt (2. W ) )
}

class Encoder4to2 extends Module {
    val io = IO ( new EncoderIO )
    when ( io . in === "b0001" . U ) {
        io . out := "b00" . U
    } .elsewhen ( io . in === "b0010" . U ) {
        io . out := "b01" . U
    } .elsewhen ( io . in === "b0100" . U ) {
        io . out := "b10" . U
    } .otherwise {
        io . out := "b11" . U
    }
}

//--------------------------------------

class DecoderIO extends Bundle {
val in = Input ( UInt (2. W ) )
val out = Output ( UInt (4. W ) )
}
class Decoder2to4 extends Module {
val io = IO ( new DecoderIO )
io . out := 0. U
switch (io.in){
    is ("b00".U){io.out := 1.U}
    is ("b01".U){io.out := 2.U}
    is ("b10".U){io.out := 3.U}
    is ("b11".U){io.out := 4.U}
}
}
// class example1 extends Decoder_2to4{}
class example1 extends Decoder2to4