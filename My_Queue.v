module Queue(
  input        clock,
  input        reset,
  output       io_enq_ready,
  input        io_enq_valid,
  input  [7:0] io_enq_bits,
  input        io_deq_ready,
  output       io_deq_valid,
  output [7:0] io_deq_bits
);
`ifdef RANDOMIZE_GARBAGE_ASSIGN
  reg [31:0] _RAND_1;
`endif // RANDOMIZE_GARBAGE_ASSIGN
`ifdef RANDOMIZE_MEM_INIT
  reg [31:0] _RAND_0;
`endif // RANDOMIZE_MEM_INIT
`ifdef RANDOMIZE_REG_INIT
  reg [31:0] _RAND_2;
  reg [31:0] _RAND_3;
  reg [31:0] _RAND_4;
`endif // RANDOMIZE_REG_INIT
  reg [7:0] ram [0:4]; // @[Decoupled.scala 218:16]
  wire [7:0] ram_io_deq_bits_MPORT_data; // @[Decoupled.scala 218:16]
  wire [2:0] ram_io_deq_bits_MPORT_addr; // @[Decoupled.scala 218:16]
  wire [7:0] ram_MPORT_data; // @[Decoupled.scala 218:16]
  wire [2:0] ram_MPORT_addr; // @[Decoupled.scala 218:16]
  wire  ram_MPORT_mask; // @[Decoupled.scala 218:16]
  wire  ram_MPORT_en; // @[Decoupled.scala 218:16]
  reg [2:0] value; // @[Counter.scala 60:40]
  reg [2:0] value_1; // @[Counter.scala 60:40]
  reg  maybe_full; // @[Decoupled.scala 221:27]
  wire  ptr_match = value == value_1; // @[Decoupled.scala 223:33]
  wire  empty = ptr_match & ~maybe_full; // @[Decoupled.scala 224:25]
  wire  full = ptr_match & maybe_full; // @[Decoupled.scala 225:24]
  wire  do_enq = io_enq_ready & io_enq_valid; // @[Decoupled.scala 40:37]
  wire  do_deq = io_deq_ready & io_deq_valid; // @[Decoupled.scala 40:37]
  wire  wrap = value == 3'h4; // @[Counter.scala 72:24]
  wire [2:0] _value_T_1 = value + 3'h1; // @[Counter.scala 76:24]
  wire  wrap_1 = value_1 == 3'h4; // @[Counter.scala 72:24]
  wire [2:0] _value_T_3 = value_1 + 3'h1; // @[Counter.scala 76:24]
  assign ram_io_deq_bits_MPORT_addr = value_1;
  `ifndef RANDOMIZE_GARBAGE_ASSIGN
  assign ram_io_deq_bits_MPORT_data = ram[ram_io_deq_bits_MPORT_addr]; // @[Decoupled.scala 218:16]
  `else
  assign ram_io_deq_bits_MPORT_data = ram_io_deq_bits_MPORT_addr >= 3'h5 ? _RAND_1[7:0] :
    ram[ram_io_deq_bits_MPORT_addr]; // @[Decoupled.scala 218:16]
  `endif // RANDOMIZE_GARBAGE_ASSIGN
  assign ram_MPORT_data = io_enq_bits;
  assign ram_MPORT_addr = value;
  assign ram_MPORT_mask = 1'h1;
  assign ram_MPORT_en = io_enq_ready & io_enq_valid;
  assign io_enq_ready = ~full; // @[Decoupled.scala 241:19]
  assign io_deq_valid = ~empty; // @[Decoupled.scala 240:19]
  assign io_deq_bits = ram_io_deq_bits_MPORT_data; // @[Decoupled.scala 242:15]
  always @(posedge clock) begin
    if(ram_MPORT_en & ram_MPORT_mask) begin
      ram[ram_MPORT_addr] <= ram_MPORT_data; // @[Decoupled.scala 218:16]
    end
    if (reset) begin // @[Counter.scala 60:40]
      value <= 3'h0; // @[Counter.scala 60:40]
    end else if (do_enq) begin // @[Decoupled.scala 229:17]
      if (wrap) begin // @[Counter.scala 86:20]
        value <= 3'h0; // @[Counter.scala 86:28]
      end else begin
        value <= _value_T_1; // @[Counter.scala 76:15]
      end
    end
    if (reset) begin // @[Counter.scala 60:40]
      value_1 <= 3'h0; // @[Counter.scala 60:40]
    end else if (do_deq) begin // @[Decoupled.scala 233:17]
      if (wrap_1) begin // @[Counter.scala 86:20]
        value_1 <= 3'h0; // @[Counter.scala 86:28]
      end else begin
        value_1 <= _value_T_3; // @[Counter.scala 76:15]
      end
    end
    if (reset) begin // @[Decoupled.scala 221:27]
      maybe_full <= 1'h0; // @[Decoupled.scala 221:27]
    end else if (do_enq != do_deq) begin // @[Decoupled.scala 236:28]
      maybe_full <= do_enq; // @[Decoupled.scala 237:16]
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
`ifdef RANDOMIZE_GARBAGE_ASSIGN
  _RAND_1 = {1{`RANDOM}};
`endif // RANDOMIZE_GARBAGE_ASSIGN
`ifdef RANDOMIZE_MEM_INIT
  _RAND_0 = {1{`RANDOM}};
  for (initvar = 0; initvar < 5; initvar = initvar+1)
    ram[initvar] = _RAND_0[7:0];
`endif // RANDOMIZE_MEM_INIT
`ifdef RANDOMIZE_REG_INIT
  _RAND_2 = {1{`RANDOM}};
  value = _RAND_2[2:0];
  _RAND_3 = {1{`RANDOM}};
  value_1 = _RAND_3[2:0];
  _RAND_4 = {1{`RANDOM}};
  maybe_full = _RAND_4[0:0];
`endif // RANDOMIZE_REG_INIT
  `endif // RANDOMIZE
end // initial
`ifdef FIRRTL_AFTER_INITIAL
`FIRRTL_AFTER_INITIAL
`endif
`endif // SYNTHESIS
endmodule
module My_Queue(
  input        clock,
  input        reset,
  output       io_in_ready,
  input        io_in_valid,
  input  [7:0] io_in_bits,
  input        io_out_ready,
  output       io_out_valid,
  output [7:0] io_out_bits
);
  wire  queue_clock; // @[Decoupled.scala 296:21]
  wire  queue_reset; // @[Decoupled.scala 296:21]
  wire  queue_io_enq_ready; // @[Decoupled.scala 296:21]
  wire  queue_io_enq_valid; // @[Decoupled.scala 296:21]
  wire [7:0] queue_io_enq_bits; // @[Decoupled.scala 296:21]
  wire  queue_io_deq_ready; // @[Decoupled.scala 296:21]
  wire  queue_io_deq_valid; // @[Decoupled.scala 296:21]
  wire [7:0] queue_io_deq_bits; // @[Decoupled.scala 296:21]
  Queue queue ( // @[Decoupled.scala 296:21]
    .clock(queue_clock),
    .reset(queue_reset),
    .io_enq_ready(queue_io_enq_ready),
    .io_enq_valid(queue_io_enq_valid),
    .io_enq_bits(queue_io_enq_bits),
    .io_deq_ready(queue_io_deq_ready),
    .io_deq_valid(queue_io_deq_valid),
    .io_deq_bits(queue_io_deq_bits)
  );
  assign io_in_ready = queue_io_enq_ready; // @[Decoupled.scala 299:17]
  assign io_out_valid = queue_io_deq_valid; // @[Main.scala 18:14]
  assign io_out_bits = queue_io_deq_bits; // @[Main.scala 18:14]
  assign queue_clock = clock;
  assign queue_reset = reset;
  assign queue_io_enq_valid = io_in_valid; // @[Decoupled.scala 297:22]
  assign queue_io_enq_bits = io_in_bits; // @[Decoupled.scala 298:21]
  assign queue_io_deq_ready = io_out_ready; // @[Main.scala 18:14]
endmodule
