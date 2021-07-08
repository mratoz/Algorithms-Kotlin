package ch02.s01.sample

import ch01.s04.sample.Stopwatch
import edu.princeton.cs.algs4.StdRandom

class SortCompare {
    companion object {
        fun <T: Comparable<T>> time(alg: String, a: Array<T>): Double {
            val timer = Stopwatch()
            when(alg) {
                "Insertion" -> InsertionSort.sort(a)
                "Selection" -> SelectionSort.sort(a)
                "Shell" -> ShellSort.sort(a)
            }
            return timer.elapsedTime()
        }

        fun timeRandomInput(alg: String, N: Int, T: Int): Double {
            var total = 0.0
            val a = Array<Double>(N){ 0.0 }
            for (t in 0..T-1) {
                for (i in 0..N-1) {
                    a[i] = StdRandom.uniform()
                }
                total += time(alg, a)
            }
            return total
        }
    }
}

fun main(args: Array<String>) {
    val alg1 = args[0]
    val alg2 = args[1]
    val N = args[2].toInt()
    val T = args[3].toInt()

    val t1 = SortCompare.timeRandomInput(alg1, N, T)
    val t2 = SortCompare.timeRandomInput(alg2, N, T)

    println("For $N random Doubles\n\t$alg1 is ${t2/t1} times faster than $alg2 ")
}