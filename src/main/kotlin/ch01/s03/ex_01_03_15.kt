package ch01.s03

import ch01.s03.sample.Queue
import edu.princeton.cs.algs4.StdIn

fun main(args: Array<String>) {
    val k = args[0].toInt()
    val q = Queue<String>()

    while (!StdIn.isEmpty()) {
        q.enqueue(StdIn.readString())
    }

    var s = ""
    repeat(k) {
        s = q.dequeue()
    }

    println(s)
}