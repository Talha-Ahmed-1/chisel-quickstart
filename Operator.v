module Operator(
  input         clock,
  input         reset,
  input  [15:0] io_in_0,
  input  [15:0] io_in_1,
  input  [15:0] io_in_2,
  input  [15:0] io_in_3,
  output [15:0] io_out
);
  wire [15:0] _io_out_T = io_in_0 & io_in_1; // @[Main.scala 10:85]
  wire [15:0] _io_out_T_1 = _io_out_T & io_in_2; // @[Main.scala 10:85]
  assign io_out = _io_out_T_1 & io_in_3; // @[Main.scala 10:85]
endmodule
