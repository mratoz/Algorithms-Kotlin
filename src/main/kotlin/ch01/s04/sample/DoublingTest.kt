package ch01.s04.sample

import edu.princeton.cs.algs4.StdRandom

class DoublingTest {
    companion object {
        fun timeTrial(n: Int): Double{
            val MAX = 1000000
            val a = Array<Int>(n){ 0 }

            for (i in 0..n-1) {
                a[i] = StdRandom.uniform(-MAX, MAX)
            }
            val timer = Stopwatch()
            val cnt = count(a)
            return timer.elapsedTime()
        }
    }
}

fun main(args: Array<String>) {
    var n = 250
    while(true) {
        val time = DoublingTest.timeTrial(n)
        println("$n \t $time")
        n += n
    }
}