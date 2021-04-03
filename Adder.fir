;buildInfoPackage: chisel3, version: 3.4.2, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Adder : 
  module Adder : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in1 : UInt<6>, flip in2 : UInt<6>, out : UInt<6>, flip sel : UInt<1>}
    
    node _io_out_T = add(io.in1, io.in2) @[Main.scala 22:26]
    node _io_out_T_1 = tail(_io_out_T, 1) @[Main.scala 22:26]
    io.out <= _io_out_T_1 @[Main.scala 22:14]
    
