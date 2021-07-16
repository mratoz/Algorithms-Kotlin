package ch02.s02.sample

import ch02.s01.sample.SortInterface
import edu.princeton.cs.algs4.In

class MergeBU {
    companion object: SortInterface {
        override fun <T : Comparable<T>> sort(a: Array<T>) {
            val aux = a.copyOf()
            val n = a.size
            var sz = 1
            while (sz < n) {
                var lo= 0
                while (lo < (n - sz)) {
                    merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1))
                    lo += (sz + sz)
                }
                sz += sz
            }

        }

        fun <T: Comparable<T>> merge(a: Array<T>, aux: Array<T>, lo: Int, mid: Int, hi: Int): Unit {
            var i = lo
            var j = mid + 1

            for (k in lo..hi) {
                aux[k] = a[k]
            }

            for (k in lo..hi) {
                if (i > mid) {
                    a[k] = aux[j++]
                } else if (j > hi) {
                    a[k] = aux[i++]
                } else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++]
                } else {
                    a[k] = aux[i++]
                }
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
    MergeBU.show(a)
    MergeBU.sort(a)
    MergeBU.show(a)
}