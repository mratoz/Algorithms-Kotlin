package ch01.s02

import edu.princeton.cs.algs4.Interval1D
import edu.princeton.cs.algs4.StdIn

fun main(args: Array<String>){
    val n: Int = args[0].toInt()
    val intervalDList = mutableListOf<Interval1D>()

    var readCounter = 0
    var first: Double = 0.0

    while(!StdIn.isEmpty()) {
        readCounter += 1
        val key = StdIn.readDouble()
        if (readCounter % 2 != 0) {
            first = key
            continue
        } else {
            intervalDList.add(Interval1D(first, key))
        }
    }

    if (readCounter != 2 * n) {
        throw Exception("Invalid interval pair input: accepted ${readCounter} expected ${2 * n}")
    }

    for (i in 0..(n - 1)) {
        for (j in (i + 1)..n-1) {
            if (intervalDList[i].intersects(intervalDList[j]))
                println("${intervalDList[i]} intersect with ${intervalDList[j]}")
        }
    }
}