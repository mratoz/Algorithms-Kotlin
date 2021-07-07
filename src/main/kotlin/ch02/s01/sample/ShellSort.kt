package ch02.s01.sample

import edu.princeton.cs.algs4.In

class ShellSort {
    companion object: SortInterface {
        override fun <T : Comparable<T>> sort(a: Array<T>) {
            val n = a.size
            var h = 1

            while (h < n/3) h = 3*h + 1

            while (h >= 1) {
                println("$h-sort: ")
                for (i in h..n-1) {
                    var j = i
                    println("$j with ${j - h}: ${a[j]} - ${a[j - h]}")
                    while (j >= h && less(a[j], a[j - h])) {
                        exch(a, j, j - h)
                        println("$i round idx to exchange: $j <-> ${j - h}")
                        j -= h
                    }
                    ShellSort.show(a)
                }
                h /= 3
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
    ShellSort.show(a)
    ShellSort.sort(a)
    ShellSort.show(a)
}