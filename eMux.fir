;buildInfoPackage: chisel3, version: 3.4.2, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit eMux : 
  module eMux : 
    input clock : Clock
    input reset : UInt<1>
    output io : {out : UInt<32>, flip in1 : UInt<32>, flip in2 : UInt<32>, flip sel : UInt<1>}
    
    node _io_out_T = mux(io.sel, io.in1, io.in2) @[Main.scala 25:12]
    io.out <= _io_out_T @[Main.scala 23:14]
    
