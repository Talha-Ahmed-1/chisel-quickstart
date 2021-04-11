;buildInfoPackage: chisel3, version: 3.4.2, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Detect_Seq : 
  module Detect_Seq : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : UInt<1>, out : UInt<1>}
    
    reg state : UInt<2>, clock with : (reset => (reset, UInt<2>("h00"))) @[Main.scala 17:25]
    node _io_out_T = eq(state, UInt<2>("h02")) @[Main.scala 18:25]
    node _io_out_T_1 = eq(io.in, UInt<1>("h00")) @[Main.scala 18:37]
    node _io_out_T_2 = and(_io_out_T, _io_out_T_1) @[Main.scala 18:34]
    io.out <= _io_out_T_2 @[Main.scala 18:14]
    node _T = eq(UInt<2>("h00"), state) @[Conditional.scala 37:30]
    when _T : @[Conditional.scala 40:58]
      when io.in : @[Main.scala 21:30]
        state <= UInt<2>("h01") @[Main.scala 23:23]
        skip @[Main.scala 21:30]
      skip @[Conditional.scala 40:58]
    else : @[Conditional.scala 39:67]
      node _T_1 = eq(UInt<2>("h01"), state) @[Conditional.scala 37:30]
      when _T_1 : @[Conditional.scala 39:67]
        when io.in : @[Main.scala 27:30]
          state <= UInt<2>("h02") @[Main.scala 29:19]
          skip @[Main.scala 27:30]
        else : @[Main.scala 30:26]
          state <= UInt<2>("h00") @[Main.scala 31:19]
          skip @[Main.scala 30:26]
        skip @[Conditional.scala 39:67]
      else : @[Conditional.scala 39:67]
        node _T_2 = eq(UInt<2>("h02"), state) @[Conditional.scala 37:30]
        when _T_2 : @[Conditional.scala 39:67]
          node _T_3 = eq(io.in, UInt<1>("h00")) @[Main.scala 35:19]
          when _T_3 : @[Main.scala 35:31]
            state <= UInt<2>("h00") @[Main.scala 38:19]
            skip @[Main.scala 35:31]
          skip @[Conditional.scala 39:67]
    
