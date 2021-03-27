package lab3
import chisel3._
import chisel3.util._

class LM_IO_Interface_BranchControl extends Bundle {
    val fnct3 = Input ( UInt (3. W ) )
    val branch = Input ( Bool () )
    val arg_x = Input ( UInt (32. W ) )
    val arg_y = Input ( UInt (32. W ) )
    val br_taken = Output ( Bool () )
}

class task1 extends Module {
    val io = IO (new LM_IO_Interface_BranchControl )
    
    def branch(io: LM_IO_Interface_BranchControl) = MuxCase(false.B, Array(
            ((io.arg_x === io.arg_y) && (io.fnct3 === "b000".U) ) -> true.B,
            ((io.arg_x =/= io.arg_y) && (io.fnct3 === "b001".U) ) -> true.B,
            ((io.arg_x < io.arg_y) && (io.fnct3 === "b100".U | io.fnct3 === "b110".U) ) -> true.B,
            ((io.arg_x >= io.arg_y) && (io.fnct3 === "b101".U | io.fnct3 === "b111".U) ) -> true.B
        ))

    // def b = (io.branch === 1.B).asInstanceOf[Int] +1
    // // def c = b < 1
    // def check = if (b == 2) branch(io) else false.B
    // io.br_taken := check
    

    io.br_taken := Mux(io.branch, branch(io), false.B)
}

// println (( new chisel3 . stage . ChiselStage ) . emitVerilog (new task1 ) )