package ch01.s03

import ch01.s03.sample.Stack

fun getBinaryStringOfInt(num: Int): String {
    val s = Stack<Int>()
    var n = num
    var res = ""

    while (n > 0) {
        s.push(n % 2)
        n = n / 2
    }

    while (!s.isEmpty()) {
        res += s.pop().toString()
    }

    return res
}

fun main(args: Array<String>) {
    val n = args[0].toInt()
    println("$n in binary form: ${getBinaryStringOfInt(n)}")
}