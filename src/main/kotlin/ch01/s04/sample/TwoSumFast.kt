package ch01.s04.sample

import edu.princeton.cs.algs4.BinarySearch
import edu.princeton.cs.algs4.In

class TwoSumFast {
    companion object {
        fun count(a: IntArray): Int {
            a.sort()
            val n = a.size
            var cnt = 0

            for (i in 0..n-1){
                if (BinarySearch.indexOf(a, -a[i]) > i) {
                     cnt++
                }
            }
            return cnt
        }
    }
}

fun main(args: Array<String>) {
    val a = In(args[0]).readAllInts()
    println(TwoSumFast.count(a))
}