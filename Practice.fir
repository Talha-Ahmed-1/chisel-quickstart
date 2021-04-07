;buildInfoPackage: chisel3, version: 3.4.2, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Practice : 
  module Practice : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : UInt<32>, out : UInt<32>}
    
    reg reg : UInt, clock with : (reset => (reset, io.in)) @[Reg.scala 27:20]
    when UInt<1>("h00") : @[Reg.scala 28:19]
      reg <= UInt<1>("h01") @[Reg.scala 28:23]
      skip @[Reg.scala 28:19]
    io.out <= reg @[Main.scala 28:12]
    
