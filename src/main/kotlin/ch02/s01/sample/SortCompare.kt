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