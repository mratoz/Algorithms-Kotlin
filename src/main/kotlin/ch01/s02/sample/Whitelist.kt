package ch01.s02.sample

import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOut

fun main(args: Array<String>) {
    val w = In(args[0]).readAllInts()
    val set = StaticSetofInts(w)

    while(!StdIn.isEmpty()) {
        var key = StdIn.readInt()
        if (!set.contains(key)) {
            StdOut.println(key)
        }
    }
}