package ch01.s03

import ch01.s03.sample.Stack
import edu.princeton.cs.algs4.In

fun convertInfixToPostfix(a: Array<String>): String {
    val ops = Stack<String>()
    val vals = Stack<String>()
    val matchPairs = arrayOf<Pair<String, String>>(Pair("(", ")"), Pair("[", "]"), Pair("{", "}"))

    for (item in a) {
        when (item) {
            "+", "-", "*", "/" -> ops.push(item)
            ")", "]", "}" -> {
                val v1 = vals.pop()
                val v2 = vals.pop()
                val op = ops.pop()
                vals.push("${matchPairs.find { it.second == item }!!.first} $v2 $v1 $op $item")
            }
            "(", "[", "{" -> continue
            else -> vals.push(item)
        }
    }

    return vals.pop()
}

fun main(args: Array<String>) {
    for (line in In(args[0]).readAllLines()) {
        val res = convertInfixToPostfix(line.split(" ").toTypedArray())
        println(res)
    }
}