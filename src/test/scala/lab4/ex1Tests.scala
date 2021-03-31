package lab4

import chisel3 . _
import chisel3 . util._
import org.scalatest._
import chiseltest._
import scala . util . Random
import ALUOP . _


class ex1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 4 ALU" in {
    test(new ex1()) { c =>
        val array_op = Array ( ALU_ADD , ALU_SUB , ALU_AND , ALU_OR , ALU_XOR , ALU_SLT , ALU_SLL
        , ALU_SLTU , ALU_SRL , ALU_SRA , ALU_COPY_A , ALU_COPY_B , ALU_XXX )
        for ( i <- 0 until 100) {
            // println("---------------%i----------------",i)
            val src_a = Random . nextLong () & 0xFFFFFFFFL
            val src_b = Random . nextLong () & 0xFFFFFFFFL
            // printf("-------------------$src_a--------------------")
            val opr = Random . nextInt (12)
            // val opr = 5
            println("---------------opr----------------",opr)
            println("---------------A----------------",src_a)
            println("---------------B----------------",src_b)
            val aluop = array_op ( opr )
            // ALU functional implementation using Scala match
            val result = aluop match {
                case ALU_ADD => src_a + src_b
                case ALU_SUB => src_a - src_b
                case ALU_AND => src_a & src_b
                case ALU_OR => src_a | src_b
                case ALU_XOR => src_a ^ src_b
                case ALU_SLT => if ( src_a < src_b ) 1 else 0
                case ALU_SLL => src_a << ( src_b & 0x1F )
                case ALU_SLTU => if ( src_a < src_b ) 1 else 0
                case ALU_SRL => src_a >> ( src_b & 0x1F )
                case ALU_SRA => src_a.toInt >> ( src_b.toInt & 0x1F )
                case ALU_COPY_A => src_a
                case ALU_COPY_B => src_b
                case _ => 0
            }
            val result1: BigInt = if ( result < 0 )
                ( BigInt (0xFFFFFFFFL ) + result + 1) & 0xFFFFFFFFL
            else result & 0xFFFFFFFFL
            // poke ( c . io . in_A , src_a . U )
            // poke ( c . io . in_B , src_b . U )
            // poke ( c . io . alu_Op , aluop )
            // step (1)
            // expect ( c . io . out , result1 . asUInt )
            // }
            // step (2)
            // println("---------------Result----------------",result)
            println("---------------Result1----------------",result1.asUInt)
            c.io.in_A.poke(src_a.U)
            c.io.in_B.poke(src_b.U)
            c.io.alu_Op.poke(aluop)
            c.clock.step(1)
            c.io.out.expect(result1.asUInt)
            }
        c.clock.step(2)

        }
    }
}

// object ex1Tests extends App {
// chisel3.Driver.execute ( Array ("--is -verbose", "--generate -vcd -output", "on", "--backend -name", "firrtl") , () => new ex1() ) {
//     c => new TestALU ()
//     }
// }   