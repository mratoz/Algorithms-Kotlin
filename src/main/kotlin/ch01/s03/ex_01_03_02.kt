package ch01.s03

import ch01.s03.sample.Stack
import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOut

fun main(args: Array<String>) {
    val s = Stack<String>()

    while(!StdIn.isEmpty()) {
        val item = StdIn.readString()
        if (item != "-") {
            s.push(item)
        } else {
            StdOut.print(s.pop() + " ")
        }
    }

    StdOut.println("( " + s.size() + " left on stack)" )
}