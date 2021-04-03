module switch_2cross2(
  input         clock,
  input         reset,
  input  [31:0] io_in1,
  input  [31:0] io_in2,
  output [31:0] io_out1,
  output [31:0] io_out2,
  input         io_sel
);
  assign io_out1 = io_sel ? io_in2 : io_in1; // @[Main.scala 20:23 Main.scala 21:19 Main.scala 25:19]
  assign io_out2 = io_sel ? io_in1 : io_in2; // @[Main.scala 20:23 Main.scala 22:19 Main.scala 26:19]
endmodule
