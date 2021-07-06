package ch02.s01.sample

import edu.princeton.cs.algs4.In

class SelectionSort {
    companion object: SortInterface {
        override fun <T: Comparable<T>> sort(a: Array<T>): Unit {
            val n = a.size
            for (i in 0..n - 1) {
                var min = i
                for (j in i + 1..n - 1){
                    println("$i: ${a[i]} $j: ${a[j]}")
                    if(less(a[j], a[min])) {
                        min = j
                    }
                }
                println("idx to exchange: $i <- $min")
                exch(a, i, min)
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
    SelectionSort.show(a)
    SelectionSort.sort(a)
    SelectionSort.show(a)
}