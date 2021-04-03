module ALU(
  input         clock,
  input         reset,
  input  [63:0] io_alu_oper,
  input  [63:0] io_arg_x,
  input  [63:0] io_arg_y,
  output [63:0] io_alu_out
);
  wire  _T = 64'h0 == io_alu_oper; // @[Conditional.scala 37:30]
  wire [63:0] _io_alu_out_T = io_arg_x & io_arg_y; // @[Main.scala 19:40]
  wire  _T_1 = 64'h1 == io_alu_oper; // @[Conditional.scala 37:30]
  wire [63:0] _io_alu_out_T_1 = io_arg_x | io_arg_y; // @[Main.scala 22:40]
  wire  _T_2 = 64'h2 == io_alu_oper; // @[Conditional.scala 37:30]
  wire [63:0] _io_alu_out_T_3 = io_arg_x + io_arg_y; // @[Main.scala 25:40]
  wire  _T_3 = 64'h6 == io_alu_oper; // @[Conditional.scala 37:30]
  wire [63:0] _io_alu_out_T_5 = io_arg_x - io_arg_y; // @[Main.scala 28:40]
  wire  _T_4 = 64'h3 == io_alu_oper; // @[Conditional.scala 37:30]
  wire [63:0] _io_alu_out_T_6 = io_arg_x ^ io_arg_y; // @[Main.scala 31:40]
  wire  _T_5 = 64'h4 == io_alu_oper; // @[Conditional.scala 37:30]
  wire [126:0] _GEN_10 = {{63'd0}, io_arg_x}; // @[Main.scala 34:40]
  wire [126:0] _io_alu_out_T_8 = _GEN_10 << io_arg_y[5:0]; // @[Main.scala 34:40]
  wire  _T_6 = 64'h5 == io_alu_oper; // @[Conditional.scala 37:30]
  wire [63:0] _io_alu_out_T_10 = io_arg_x >> io_arg_y[5:0]; // @[Main.scala 37:40]
  wire  _T_7 = 64'h7 == io_alu_oper; // @[Conditional.scala 37:30]
  wire [63:0] _io_alu_out_T_14 = $signed(io_arg_x) >>> io_arg_y[5:0]; // @[Main.scala 40:85]
  wire  _T_8 = 64'h8 == io_alu_oper; // @[Conditional.scala 37:30]
  wire  _T_9 = 64'h9 == io_alu_oper; // @[Conditional.scala 37:30]
  wire  _GEN_0 = _T_9 & io_arg_x < io_arg_y; // @[Conditional.scala 39:67 Main.scala 46:26 Main.scala 15:18]
  wire  _GEN_1 = _T_8 ? $signed(io_arg_x) < $signed(io_arg_y) : _GEN_0; // @[Conditional.scala 39:67 Main.scala 43:26]
  wire [63:0] _GEN_2 = _T_7 ? _io_alu_out_T_14 : {{63'd0}, _GEN_1}; // @[Conditional.scala 39:67 Main.scala 40:26]
  wire [63:0] _GEN_3 = _T_6 ? _io_alu_out_T_10 : _GEN_2; // @[Conditional.scala 39:67 Main.scala 37:26]
  wire [126:0] _GEN_4 = _T_5 ? _io_alu_out_T_8 : {{63'd0}, _GEN_3}; // @[Conditional.scala 39:67 Main.scala 34:26]
  wire [126:0] _GEN_5 = _T_4 ? {{63'd0}, _io_alu_out_T_6} : _GEN_4; // @[Conditional.scala 39:67 Main.scala 31:26]
  wire [126:0] _GEN_6 = _T_3 ? {{63'd0}, _io_alu_out_T_5} : _GEN_5; // @[Conditional.scala 39:67 Main.scala 28:26]
  wire [126:0] _GEN_7 = _T_2 ? {{63'd0}, _io_alu_out_T_3} : _GEN_6; // @[Conditional.scala 39:67 Main.scala 25:26]
  wire [126:0] _GEN_8 = _T_1 ? {{63'd0}, _io_alu_out_T_1} : _GEN_7; // @[Conditional.scala 39:67 Main.scala 22:26]
  wire [126:0] _GEN_9 = _T ? {{63'd0}, _io_alu_out_T} : _GEN_8; // @[Conditional.scala 40:58 Main.scala 19:26]
  assign io_alu_out = _GEN_9[63:0];
endmodule
