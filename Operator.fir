;buildInfoPackage: chisel3, version: 3.4.2, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Operator : 
  module Operator : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : UInt<16>[4], out : UInt<16>}
    
    node _io_out_T = and(io.in[0], io.in[1]) @[Main.scala 10:85]
    node _io_out_T_1 = and(_io_out_T, io.in[2]) @[Main.scala 10:85]
    node _io_out_T_2 = and(_io_out_T_1, io.in[3]) @[Main.scala 10:85]
    io.out <= _io_out_T_2 @[Main.scala 22:12]
    
