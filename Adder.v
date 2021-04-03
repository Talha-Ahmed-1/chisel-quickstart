module Adder(
  input        clock,
  input        reset,
  input  [5:0] io_in1,
  input  [5:0] io_in2,
  output [5:0] io_out,
  input        io_sel
);
  assign io_out = io_in1 + io_in2; // @[Main.scala 22:26]
endmodule
