package ch01.s03.sample

import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOut

class FixedCapacityStack<T: Any?>(cap: Int) {
    private val a: Array<Any?> = arrayOfNulls(cap)
    private var n = 0

    public fun isEmpty(): Boolean { return n == 0 }
    public fun size(): Int { return n }

    public fun <T> push(item: T): Unit {
        a[n++] = item
    }

    public fun <T> pop(): T {
        return a[--n] as T
    }
}

fun main(args: Array<String>) {
    val s = FixedCapacityStack<String>(100)

    while(!StdIn.isEmpty()) {
        val item = StdIn.readString()
        if (!item.equals("-")) {
            s.push(item)
        } else if (!s.isEmpty()) {
            val s: String = s.pop()
            StdOut.print(s + " ")
        }
    }
    StdOut.println("( " + s.size() + " left on stack)")
}
