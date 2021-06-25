package ch01.s03.sample

import edu.princeton.cs.algs4.Stack
import edu.princeton.cs.algs4.StdIn
import kotlin.math.sqrt


fun main(args: Array<String>) {
    val ops: Stack<String> = Stack<String>()
    val vals: Stack<Double> = Stack<Double>()

    while(!StdIn.isEmpty()) {
        val s = StdIn.readString()
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

    println(vals.pop())
}