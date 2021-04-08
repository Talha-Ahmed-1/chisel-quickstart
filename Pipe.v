module Pipe(
  input        clock,
  input        reset,
  input        io_in_valid,
  input  [7:0] io_in_bits,
  output       io_out_valid,
  output [7:0] io_out_bits
);
`ifdef RANDOMIZE_REG_INIT
  reg [31:0] _RAND_0;
  reg [31:0] _RAND_1;
  reg [31:0] _RAND_2;
  reg [31:0] _RAND_3;
  reg [31:0] _RAND_4;
  reg [31:0] _RAND_5;
  reg [31:0] _RAND_6;
  reg [31:0] _RAND_7;
  reg [31:0] _RAND_8;
  reg [31:0] _RAND_9;
`endif // RANDOMIZE_REG_INIT
  reg  io_out_v; // @[Valid.scala 117:22]
  reg [7:0] io_out_b; // @[Reg.scala 15:16]
  reg  io_out_outPipe_valid; // @[Valid.scala 117:22]
  reg [7:0] io_out_outPipe_bits; // @[Reg.scala 15:16]
  reg  io_out_outPipe_valid_1; // @[Valid.scala 117:22]
  reg [7:0] io_out_outPipe_bits_1; // @[Reg.scala 15:16]
  reg  io_out_outPipe_valid_2; // @[Valid.scala 117:22]
  reg [7:0] io_out_outPipe_bits_2; // @[Reg.scala 15:16]
  reg  io_out_outPipe_valid_3; // @[Valid.scala 117:22]
  reg [7:0] io_out_outPipe_bits_3; // @[Reg.scala 15:16]
  assign io_out_valid = io_out_outPipe_valid_3; // @[Valid.scala 112:21 Valid.scala 113:17]
  assign io_out_bits = io_out_outPipe_bits_3; // @[Valid.scala 112:21 Valid.scala 114:16]
  always @(posedge clock) begin
    if (reset) begin // @[Valid.scala 117:22]
      io_out_v <= 1'h0; // @[Valid.scala 117:22]
    end else begin
      io_out_v <= io_in_valid; // @[Valid.scala 117:22]
    end
    if (io_in_valid) begin // @[Reg.scala 16:19]
      io_out_b <= io_in_bits; // @[Reg.scala 16:23]
    end
    if (reset) begin // @[Valid.scala 117:22]
      io_out_outPipe_valid <= 1'h0; // @[Valid.scala 117:22]
    end else begin
      io_out_outPipe_valid <= io_out_v; // @[Valid.scala 117:22]
    end
    if (io_out_v) begin // @[Reg.scala 16:19]
      io_out_outPipe_bits <= io_out_b; // @[Reg.scala 16:23]
    end
    if (reset) begin // @[Valid.scala 117:22]
      io_out_outPipe_valid_1 <= 1'h0; // @[Valid.scala 117:22]
    end else begin
      io_out_outPipe_valid_1 <= io_out_outPipe_valid; // @[Valid.scala 117:22]
    end
    if (io_out_outPipe_valid) begin // @[Reg.scala 16:19]
      io_out_outPipe_bits_1 <= io_out_outPipe_bits; // @[Reg.scala 16:23]
    end
    if (reset) begin // @[Valid.scala 117:22]
      io_out_outPipe_valid_2 <= 1'h0; // @[Valid.scala 117:22]
    end else begin
      io_out_outPipe_valid_2 <= io_out_outPipe_valid_1; // @[Valid.scala 117:22]
    end
    if (io_out_outPipe_valid_1) begin // @[Reg.scala 16:19]
      io_out_outPipe_bits_2 <= io_out_outPipe_bits_1; // @[Reg.scala 16:23]
    end
    if (reset) begin // @[Valid.scala 117:22]
      io_out_outPipe_valid_3 <= 1'h0; // @[Valid.scala 117:22]
    end else begin
      io_out_outPipe_valid_3 <= io_out_outPipe_valid_2; // @[Valid.scala 117:22]
    end
    if (io_out_outPipe_valid_2) begin // @[Reg.scala 16:19]
      io_out_outPipe_bits_3 <= io_out_outPipe_bits_2; // @[Reg.scala 16:23]
    end
  end
// Register and memory initialization
`ifdef RANDOMIZE_GARBAGE_ASSIGN
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_INVALID_ASSIGN
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_REG_INIT
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_MEM_INIT
`define RANDOMIZE
`endif
`ifndef RANDOM
`define RANDOM $random
`endif
`ifdef RANDOMIZE_MEM_INIT
  integer initvar;
`endif
`ifndef SYNTHESIS
`ifdef FIRRTL_BEFORE_INITIAL
`FIRRTL_BEFORE_INITIAL
`endif
initial begin
  `ifdef RANDOMIZE
    `ifdef INIT_RANDOM
      `INIT_RANDOM
    `endif
    `ifndef VERILATOR
      `ifdef RANDOMIZE_DELAY
        #`RANDOMIZE_DELAY begin end
      `else
        #0.002 begin end
      `endif
    `endif
`ifdef RANDOMIZE_REG_INIT
  _RAND_0 = {1{`RANDOM}};
  io_out_v = _RAND_0[0:0];
  _RAND_1 = {1{`RANDOM}};
  io_out_b = _RAND_1[7:0];
  _RAND_2 = {1{`RANDOM}};
  io_out_outPipe_valid = _RAND_2[0:0];
  _RAND_3 = {1{`RANDOM}};
  io_out_outPipe_bits = _RAND_3[7:0];
  _RAND_4 = {1{`RANDOM}};
  io_out_outPipe_valid_1 = _RAND_4[0:0];
  _RAND_5 = {1{`RANDOM}};
  io_out_outPipe_bits_1 = _RAND_5[7:0];
  _RAND_6 = {1{`RANDOM}};
  io_out_outPipe_valid_2 = _RAND_6[0:0];
  _RAND_7 = {1{`RANDOM}};
  io_out_outPipe_bits_2 = _RAND_7[7:0];
  _RAND_8 = {1{`RANDOM}};
  io_out_outPipe_valid_3 = _RAND_8[0:0];
  _RAND_9 = {1{`RANDOM}};
  io_out_outPipe_bits_3 = _RAND_9[7:0];
`endif // RANDOMIZE_REG_INIT
  `endif // RANDOMIZE
end // initial
`ifdef FIRRTL_AFTER_INITIAL
`FIRRTL_AFTER_INITIAL
`endif
`endif // SYNTHESIS
endmodule
