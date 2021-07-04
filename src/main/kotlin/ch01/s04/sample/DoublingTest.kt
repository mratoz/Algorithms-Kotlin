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
            val cnt = ThreeSum.count(a)
            return timer.elapsedTime()
        }
    }
}


/*
250 	 0.016
500 	 0.022
1000 	 0.11
2000 	 1.299
4000 	 10.219
8000 	 81.571
 */
fun main(args: Array<String>) {
    var n = 250
    while(true) {
        val time = DoublingTest.timeTrial(n)
        println("$n \t $time")
        n += n
    }
}