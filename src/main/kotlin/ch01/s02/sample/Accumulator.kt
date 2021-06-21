package ch01.s02.sample

import edu.princeton.cs.algs4.StdRandom

class Accumulator {
    private var total: Double = 0.0
    private var n: Int = 0

    public fun addDataValue(v: Double): Unit {
        n++
        total += v
    }

    public fun mean(): Double {
        return total/n
    }

    public override fun toString(): String {
        return "Mean (${n}) values: ${mean()}"
    }
}

fun main(args: Array<String>) {
    val t: Int = args[0].toInt()
    val a: Accumulator = Accumulator()
    for (i in 1..t) {
        a.addDataValue(StdRandom.random())
    }
    println(a)
}