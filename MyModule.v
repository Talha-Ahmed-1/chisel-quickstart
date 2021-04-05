module MyModule(
  input         clock,
  input         reset,
  input  [15:0] io_inPacket_data,
  input  [15:0] io_inPacket_header,
  input  [15:0] io_inPacket_addr,
  output [15:0] io_outPacket_data,
  output [15:0] io_outPacket_header,
  output [15:0] io_outPacket_addr
);
  assign io_outPacket_data = io_inPacket_data; // @[Main.scala 33:17]
  assign io_outPacket_header = io_inPacket_header; // @[Main.scala 33:17]
  assign io_outPacket_addr = io_inPacket_addr; // @[Main.scala 33:17]
endmodule
