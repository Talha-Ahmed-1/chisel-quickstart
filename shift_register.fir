;buildInfoPackage: chisel3, version: 3.4.2, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit shift_register : 
  module shift_register : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : UInt<1>, out : UInt<4>}
    
    reg state : UInt<4>, clock with : (reset => (reset, UInt<4>("h01"))) @[Main.scala 16:25]
    node _nextState_T = shl(state, 1) @[Main.scala 18:29]
    node nextState = or(_nextState_T, io.in) @[Main.scala 18:35]
    state <= nextState @[Main.scala 19:11]
    io.out <= state @[Main.scala 20:14]
    
