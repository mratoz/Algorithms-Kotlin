package ch01.s03

import ch01.s03.sample.Stack
import edu.princeton.cs.algs4.In
import kotlin.math.sqrt

fun main(args: Array<String>) {
    for (line in In(args[0]).readAllLines()) {
        val res = convertInfixToPostfix(line.split(" ").toTypedArray())
        val resArray = res.split(" ")

        val ops: Stack<String> = Stack<String>()
        val vals: Stack<Double> = Stack<Double>()

        for (s in resArray) {
            when(s) {
                "(" -> continue
                "+", "-", "*", "/", "sqrt" -> ops.push(s)
                ")" -> {
                    val op = ops.pop()
                    var v = vals.pop()
                    when(op) {
                        "+" -> v = vals.pop() + v
                        "-" -> v = vals.pop() - v
                        "*" -> v= vals.pop() * v
                        "/" -> v = vals.pop() / v
                        "sqrt" -> v =  sqrt(v.toDouble())
                    }
                    vals.push(v)
                }
                else -> vals.push(s.toDouble())
            }
        }

        println("$line -> $res: ${vals.pop()}")
    }
}