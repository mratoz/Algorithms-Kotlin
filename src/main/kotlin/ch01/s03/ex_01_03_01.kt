package ch01.s03

import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOut

class FixedCapacityStackOfStrings(val cap: Int) {
    private var a: Array<String> = Array<String>(cap) {""}
    private var n: Int = 0

    public fun isEmpty(): Boolean { return n == 0 }
    public fun isFull(): Boolean { return n == cap }
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
