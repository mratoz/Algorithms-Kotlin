package ch01.s03

import ch01.s03.sample.Stack
import edu.princeton.cs.algs4.In

fun completeMissingParenthesesInExpression(a: Array<String>): String {
    val ops = Stack<String>()
    val vals = Stack<String>()
    val matchPairs = arrayOf<Pair<String, String>>(Pair("(", ")"), Pair("[", "]"), Pair("{", "}"))

    for (item in a) {
        when(item) {
            "+", "-", "*", "/" -> ops.push(item)
            ")", "]", "}" -> {
                val v1 = vals.pop()
                val v2 = vals.pop()
                val op = ops.pop()
                vals.push("${matchPairs.find { it.second == item }!!.first} $v2 $op $v1 $item")
            }
            else -> vals.push(item)
        }
    }

    return vals.pop()
}

fun main(args: Array<String>) {
    val a = In(args[0]).readAllStrings()
    val res = completeMissingParenthesesInExpression(a)
    println(res)
}