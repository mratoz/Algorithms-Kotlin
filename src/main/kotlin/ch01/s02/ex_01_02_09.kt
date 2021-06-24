package ch01.s02

import edu.princeton.cs.algs4.Counter
import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.StdIn

private class BinarySearch {
    companion object {
        fun rank(key: Int, a: IntArray, counter: Counter): Int {
            var lo = 0;
            var hi = a.size - 1
            while(lo <= hi) {
                val mid = lo + (hi - lo) / 2
                counter.increment()
                if (key < a[mid]) {
                    hi = mid - 1
                } else if (key > a[mid]) {
                    lo = mid + 1
                } else {
                    return mid
                }
            }
            return -1
        }
    }
}

fun main(args: Array<String>) {
    val whiteList = In(args[0]).readAllInts()
    whiteList.sort()

    while(!StdIn.isEmpty()) {
        val key = StdIn.readInt()
        val counter = Counter("compareCounter")
        val res = BinarySearch.rank(key, whiteList, counter)
        if (res != -1) {
            println("$key found with ${counter.tally()} comparison")
        }
        else {
            println("$key not found with ${counter.tally()} comparison")
        }
    }
}

