package ch01.s03

import ch01.s03.sample.Stack
import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.StdIn

fun Parentheses(str: Array<String>): Boolean {
    val s = Stack<String>()

    for (item in str) {
        if (item != ")" && item != "]" && item != "}") {
            s.push(item)
        } else {
            val p = s.pop()
            if (arrayOf<Pair<String, String>>(Pair("(", ")"), Pair("[", "]"),  Pair("{", "}")).contains(Pair(p, item))) {
                continue
            }
            else {
                return false
            }
        }
    }

    if (s.size() == 0) {
        return true
    } else {
        return false
    }
}

fun main(args: Array<String>) {
    val fc = In(args[0]).readAllStrings()
    val res = Parentheses(fc)
    println(res)
}