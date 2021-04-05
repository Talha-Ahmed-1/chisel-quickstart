;buildInfoPackage: chisel3, version: 3.4.2, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit MyModule : 
  module MyModule : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip inPacket : {data : UInt<16>, header : UInt<16>, addr : UInt<16>}, outPacket : {data : UInt<16>, header : UInt<16>, addr : UInt<16>}}
    
    io.outPacket.addr <= io.inPacket.addr @[Main.scala 33:17]
    io.outPacket.header <= io.inPacket.header @[Main.scala 33:17]
    io.outPacket.data <= io.inPacket.data @[Main.scala 33:17]
    
