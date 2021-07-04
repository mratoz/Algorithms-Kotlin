package ch01.s04.sample

import edu.princeton.cs.algs4.StdRandom

class DoublingTestForThreeSumFast {
    companion object {
        fun timeTrial(n: Int): Double{
            val MAX = 1000000
            val a = IntArray(n)

            for (i in 0..n-1) {
                a[i] = StdRandom.uniform(-MAX, MAX)
            }
            val timer = Stopwatch()
            val cnt = ThreeSumFast.count(a)
            return timer.elapsedTime()
        }
    }
}

/*
250 	 0.012
500 	 0.006
1000 	 0.015
2000 	 0.063
4000 	 0.264
8000 	 1.164
16000 	 4.482
32000 	 18.579
 */

fun main(args: Array<String>) {
    var n = 250
    while(true) {
        val time = DoublingTestForThreeSumFast.timeTrial(n)
        println("$n \t $time")
        n += n
    }
}