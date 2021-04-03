;buildInfoPackage: chisel3, version: 3.4.2, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit switch_2cross2 : 
  module switch_2cross2 : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in1 : UInt<32>, flip in2 : UInt<32>, out1 : UInt<32>, out2 : UInt<32>, flip sel : UInt<1>}
    
    when io.sel : @[Main.scala 20:23]
      io.out1 <= io.in2 @[Main.scala 21:19]
      io.out2 <= io.in1 @[Main.scala 22:19]
      skip @[Main.scala 20:23]
    else : @[Main.scala 24:16]
      io.out1 <= io.in1 @[Main.scala 25:19]
      io.out2 <= io.in2 @[Main.scala 26:19]
      skip @[Main.scala 24:16]
    
