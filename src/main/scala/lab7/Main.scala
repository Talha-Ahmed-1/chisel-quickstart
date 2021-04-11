package lab7

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum

object Main extends App{
    println((new chisel3.stage.ChiselStage).emitVerilog(new Detect_Seq))
}

class Detect_Seq extends Module {
    val io = IO (new Bundle {
        val in = Input ( Bool () )
        val out = Output ( Bool () )
    })
    val s0 :: s1 :: s2 :: Nil = Enum (3) // Enumeration type
    val state = RegInit ( s0 ) // state = s0
    io . out := ( state === s2 ) & (! io . in ) // Mealy type state machine
    switch ( state ) {
        is ( s0 ) {
            when ( io . in ) {
            // move to next state when input is 1
                state := s1
            }
        }
        is ( s1 ) {
            when ( io . in ) {
            // move to next state when input is 1
            state := s2
            } .otherwise {
            state := s0
            }
        }
        is ( s2 ) {
            when (! io . in ) {
            // move to default state when input is zero
            // otherwise stay here because input sequence is 111
            state := s0
            }
        }
    }
}


