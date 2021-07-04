package ch01.s04.sample

import edu.princeton.cs.algs4.StdRandom
import ch01.s04.sample.count

class Stopwatch {
    var start: Long = 0

    init {
        start = System.currentTimeMillis()
    }

    fun elapsedTime(): Double {
        val now = System.currentTimeMillis()
        return (now - start) / 1000.0
    }
}

fun main(args: Array<String>) {
    val n = args[0].toInt()
    val a = Array<Int>(n){ 0 }
    for (i in 0..n-1) {
        a[i] = StdRandom.uniform(-1000000, 1000000)
    }
    val timer = Stopwatch()
    val cnt = count(a)
    val time = timer.elapsedTime()

    println("$cnt triples $time seconds")

}