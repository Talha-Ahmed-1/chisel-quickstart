// package lab3

// import org.scalatest._
// import chiseltest._
// import chisel3._

// class AluTests extends FreeSpec with ChiselScalatestTester {

//   "Lab 3 ALU" in {
//     test(new Alu()) { c =>
//       c.io.in_A.poke(20.U)
//       c.io.in_B.poke(10.U)
//       c.io.alu_Op.poke(0.U)
//       c.clock.step(1)
//       c.io.sum.expect(30.U)
//       c.io.out.expect(30.U)
//     }
//   }
// }