package ch02.s01.sample

import edu.princeton.cs.algs4.In

class InsertionSort {
    companion object: SortInterface {
        override fun <T: Comparable<T>> sort(a: Array<T>): Unit {
            val n = a.size
            for (i in 1..n - 1) {
                var j = i
                while (j > 0 && less(a[j], a[j - 1])) {
                    exch(a, j, j - 1)
                    j--
                    println("$i round idx to exchange: $j <- ${j - 1}")
                }
                show(a)
            }
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
    InsertionSort.show(a)
    InsertionSort.sort(a)
    InsertionSort.show(a)
}