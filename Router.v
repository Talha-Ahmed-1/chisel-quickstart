module Router(
  input         clock,
  input         reset,
  input  [15:0] io_in_data,
  input  [9:0]  io_in_addr,
  output [15:0] io_out_data,
  output [9:0]  io_out_addr
);
  assign io_out_data = io_in_data; // @[Main.scala 32:12]
  assign io_out_addr = io_in_addr; // @[Main.scala 32:12]
endmodule
