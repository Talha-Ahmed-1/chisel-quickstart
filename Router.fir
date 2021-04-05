;buildInfoPackage: chisel3, version: 3.4.2, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Router : 
  module Router : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : {data : UInt<16>, addr : UInt<10>}, out : {data : UInt<16>, addr : UInt<10>}}
    
    io.out.addr <= io.in.addr @[Main.scala 32:12]
    io.out.data <= io.in.data @[Main.scala 32:12]
    
