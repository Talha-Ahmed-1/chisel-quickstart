package lab2

import chisel3._
import chisel3.util._


class task2 extends Module {
    val io = IO ( new Bundle {
    val in = Vec (4 , Input ( Bool () ) )
    val sel = Vec (2 , Input ( Bool () ) )
    val shift_type = Input ( Bool () )
    val out = Vec (4 , Output ( Bool () ) )
})
// Start you code here
    val mux1 = MuxCase(false.B , Array(
        (io.sel(0)+io.sel(0) === 0.U) -> io.in(3.U),
        (io.sel(0)+io.sel(1) === 1.U) -> io.in(2.U),
        (io.sel(1)+io.sel(0) === 2.U) -> io.in(1.U),
        (io.sel(1)+io.sel(1) === 3.U) -> io.in(0.U)
    ))

    val mux2 = MuxCase(false.B , Array(
        (io.sel(0)+io.sel(0) === 0.U) -> io.in(2.U),
        (io.sel(0)+io.sel(1) === 1.U) -> io.in(1.U),
        (io.sel(1)+io.sel(0) === 2.U) -> io.in(0.U),
        (io.sel(1)+io.sel(1) === 3.U) -> Mux(io.shift_type === 1.U , io.in(3.U) << 1.U , io.in(3.U) >> 1.U)
        // (io.sel(1)+io.sel(1) === 3.U) -> io.in(3.U)
    ))

    val mux3 = MuxCase(false.B , Array(
        (io.sel(0)+io.sel(0) === 0.U) -> io.in(1.U),
        (io.sel(0)+io.sel(1) === 1.U) -> io.in(0.U),
        (io.sel(1)+io.sel(0) === 2.U) -> Mux(io.shift_type === 1.U , io.in(3.U) << 1.U , io.in(3.U) >> 1.U),
        (io.sel(1)+io.sel(1) === 3.U) -> Mux(io.shift_type === 1.U , io.in(2.U) << 1.U , io.in(2.U) >> 1.U)
    ))

    val mux4 = MuxCase(false.B , Array(
        (io.sel(0)+io.sel(0) === 0.U) -> io.in(0.U),
        (io.sel(0)+io.sel(1) === 1.U) -> Mux(io.shift_type === 1.U , io.in(3.U) << 1.U , io.in(3.U) >> 1.U),
        (io.sel(1)+io.sel(0) === 2.U) -> Mux(io.shift_type === 1.U , io.in(2.U) << 1.U , io.in(2.U) >> 1.U),
        (io.sel(1)+io.sel(1) === 3.U) -> Mux(io.shift_type === 1.U , io.in(1.U) << 1.U , io.in(1.U) >> 1.U)
    ))

    io.out(0) := mux1
    io.out(1) := mux2
    io.out(2) := mux3
    io.out(3) := mux4
    // io.out(0) := mux1

// End your code here
}