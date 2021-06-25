package ch01.s03.sample

import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOut

class FixedCapacityStackOfStrings(cap: Int) {
    private lateinit var a: Array<String>
    private var n: Int = 0

    init {
        a = Array<String>(cap) {""}
    }

    public fun isEmpty(): Boolean { return n == 0 }
    public fun size(): Int { return n }

    public fun push(item: String): Unit {
        a[n++] = item
    }

    public fun pop(): String {
        return a[--n]
    }
}

fun main(args: Array<String>) {
    val s = FixedCapacityStackOfStrings(100)

    while(!StdIn.isEmpty()) {
        val item = StdIn.readString()
        if (!item.equals("-")) {
            s.push(item)
        } else if (!s.isEmpty()) {
            StdOut.print(s.pop() + " ")
        }
    }
    StdOut.println("( " + s.size() + " left on stack)")
}
