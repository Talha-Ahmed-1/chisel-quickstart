module Detect_Seq(
  input   clock,
  input   reset,
  input   io_in,
  output  io_out
);
`ifdef RANDOMIZE_REG_INIT
  reg [31:0] _RAND_0;
`endif // RANDOMIZE_REG_INIT
  reg [1:0] state; // @[Main.scala 17:25]
  wire  _io_out_T_1 = ~io_in; // @[Main.scala 18:37]
  wire  _T = 2'h0 == state; // @[Conditional.scala 37:30]
  wire  _T_1 = 2'h1 == state; // @[Conditional.scala 37:30]
  wire  _T_2 = 2'h2 == state; // @[Conditional.scala 37:30]
  wire [1:0] _GEN_2 = _io_out_T_1 ? 2'h0 : state; // @[Main.scala 35:31 Main.scala 38:19 Main.scala 17:25]
  assign io_out = state == 2'h2 & ~io_in; // @[Main.scala 18:34]
  always @(posedge clock) begin
    if (reset) begin // @[Main.scala 17:25]
      state <= 2'h0; // @[Main.scala 17:25]
    end else if (_T) begin // @[Conditional.scala 40:58]
      if (io_in) begin // @[Main.scala 21:30]
        state <= 2'h1; // @[Main.scala 23:23]
      end
    end else if (_T_1) begin // @[Conditional.scala 39:67]
      if (io_in) begin // @[Main.scala 27:30]
        state <= 2'h2; // @[Main.scala 29:19]
      end else begin
        state <= 2'h0; // @[Main.scala 31:19]
      end
    end else if (_T_2) begin // @[Conditional.scala 39:67]
      state <= _GEN_2;
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
  state = _RAND_0[1:0];
`endif // RANDOMIZE_REG_INIT
  `endif // RANDOMIZE
end // initial
`ifdef FIRRTL_AFTER_INITIAL
`FIRRTL_AFTER_INITIAL
`endif
`endif // SYNTHESIS
endmodule
