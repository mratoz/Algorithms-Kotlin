package ch01.s04.sample

import edu.princeton.cs.algs4.BinarySearch
import edu.princeton.cs.algs4.In

class ThreeSumFast {
    companion object {
        fun count(a: IntArray): Int {
            a.sort()
            val n = a.size
            var cnt = 0

            for (i in 0..n-1) {
                for (j in i+1..n-1) {
                    if (BinarySearch.indexOf(a, -a[i] - a[j]) > j) {
                        cnt++
                    }
                }
            }

            return cnt
        }
    }
}

fun main(args: Array<String>) {
    val a = In(args[0]).readAllInts()
    println(ThreeSumFast.count(a))
}