package ch02.s03.sample

import ch02.s01.sample.SortInterface
import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.StdRandom

public class QuickSort{
    companion object: SortInterface {
        override public fun <T : Comparable<T>> sort(a: Array<T>) {
            StdRandom.shuffle(a)
            sort(a, 0, a.size - 1)
        }

        private fun <T : Comparable<T>> sort(a: Array<T>, lo: Int, hi: Int) {
            if (hi <= lo) return
            val j = partition(a, lo, hi)
            sort(a, lo, j-1)
            sort(a, j+1, hi)
        }

        private fun <T : Comparable<T>> partition(a: Array<T>, lo: Int, hi: Int): Int {
            var i = lo
            var j = hi+1
            val v = a[lo]
            while (true) {
                while (less(a[++i], v)) if (i == hi) break
                while (less(v, a[--j])) if (j == lo) break
                if (i >= j) break
                exch(a, i, j)
            }
            exch(a, lo, j)
            return j
        }

        override fun <T: Comparable<T>> less(v: T, w: T): Boolean {
            return v.compareTo(w) < 0
        }

        override fun <T: Comparable<T>> exch(a: Array<T>, i: Int, j: Int): Unit {
            val t = a[i]
            a[i] = a[j]
            a[j] = t
        }

        override fun <T: Comparable<T>> show(a: Array<T>): Unit {
            var s = ""
            for (item in a) {
                s += item.toString()
            }
            println(s)
        }

        override fun <T: Comparable<T>> isSorted(a: Array<T>): Boolean {
            for (i in 1..a.size - 1) {
                if (less(a[i], a[i-1])) {
                    return false
                }
            }
            return true
        }
    }
}

fun main(args: Array<String>) {
    val a = In(args[0]).readAllStrings()
    QuickSort.show(a)
    QuickSort.sort(a)
    QuickSort.show(a)
}