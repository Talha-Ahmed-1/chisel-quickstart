;buildInfoPackage: chisel3, version: 3.4.2, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Pipe : 
  module Pipe : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : {valid : UInt<1>, bits : UInt<8>}, out : {valid : UInt<1>, bits : UInt<8>}}
    
    reg io_out_v : UInt<1>, clock with : (reset => (reset, UInt<1>("h00"))) @[Valid.scala 117:22]
    io_out_v <= io.in.valid @[Valid.scala 117:22]
    reg io_out_b : UInt<8>, clock @[Reg.scala 15:16]
    when io.in.valid : @[Reg.scala 16:19]
      io_out_b <= io.in.bits @[Reg.scala 16:23]
      skip @[Reg.scala 16:19]
    reg io_out_outPipe_valid : UInt<1>, clock with : (reset => (reset, UInt<1>("h00"))) @[Valid.scala 117:22]
    io_out_outPipe_valid <= io_out_v @[Valid.scala 117:22]
    reg io_out_outPipe_bits : UInt<8>, clock @[Reg.scala 15:16]
    when io_out_v : @[Reg.scala 16:19]
      io_out_outPipe_bits <= io_out_b @[Reg.scala 16:23]
      skip @[Reg.scala 16:19]
    reg io_out_outPipe_valid_1 : UInt<1>, clock with : (reset => (reset, UInt<1>("h00"))) @[Valid.scala 117:22]
    io_out_outPipe_valid_1 <= io_out_outPipe_valid @[Valid.scala 117:22]
    reg io_out_outPipe_bits_1 : UInt<8>, clock @[Reg.scala 15:16]
    when io_out_outPipe_valid : @[Reg.scala 16:19]
      io_out_outPipe_bits_1 <= io_out_outPipe_bits @[Reg.scala 16:23]
      skip @[Reg.scala 16:19]
    reg io_out_outPipe_valid_2 : UInt<1>, clock with : (reset => (reset, UInt<1>("h00"))) @[Valid.scala 117:22]
    io_out_outPipe_valid_2 <= io_out_outPipe_valid_1 @[Valid.scala 117:22]
    reg io_out_outPipe_bits_2 : UInt<8>, clock @[Reg.scala 15:16]
    when io_out_outPipe_valid_1 : @[Reg.scala 16:19]
      io_out_outPipe_bits_2 <= io_out_outPipe_bits_1 @[Reg.scala 16:23]
      skip @[Reg.scala 16:19]
    reg io_out_outPipe_valid_3 : UInt<1>, clock with : (reset => (reset, UInt<1>("h00"))) @[Valid.scala 117:22]
    io_out_outPipe_valid_3 <= io_out_outPipe_valid_2 @[Valid.scala 117:22]
    reg io_out_outPipe_bits_3 : UInt<8>, clock @[Reg.scala 15:16]
    when io_out_outPipe_valid_2 : @[Reg.scala 16:19]
      io_out_outPipe_bits_3 <= io_out_outPipe_bits_2 @[Reg.scala 16:23]
      skip @[Reg.scala 16:19]
    wire io_out_out : {valid : UInt<1>, bits : UInt<8>} @[Valid.scala 112:21]
    io_out_out.valid <= io_out_outPipe_valid_3 @[Valid.scala 113:17]
    io_out_out.bits <= io_out_outPipe_bits_3 @[Valid.scala 114:16]
    io.out.bits <= io_out_out.bits @[Main.scala 17:14]
    io.out.valid <= io_out_out.valid @[Main.scala 17:14]
    
