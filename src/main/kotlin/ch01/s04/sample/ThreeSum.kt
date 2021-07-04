package ch01.s04.sample

import edu.princeton.cs.algs4.In

class ThreeSum {
    companion object {
        fun count(a: Array<Int>): Int {
            val n = a.size
            var cnt = 0

            for (i in 0..n-1) {
                for (j in i+1..n-1)
                    for (k in j+1..n-1) {
                        if (a[i] + a[j] + a[k] == 0) {
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
    println(ThreeSum.count(a.toTypedArray()))
}