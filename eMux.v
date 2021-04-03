module eMux(
  input         clock,
  input         reset,
  output [31:0] io_out,
  input  [31:0] io_in1,
  input  [31:0] io_in2,
  input         io_sel
);
  assign io_out = io_sel ? io_in1 : io_in2; // @[Main.scala 25:12]
endmodule
