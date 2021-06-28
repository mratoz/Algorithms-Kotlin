package ch01.s03

import ch01.s03.sample.FixedCapacityStackOfStrings
import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOut

class DoublingStackOfString(initCap: Int = 1): Iterator<String?> {
    var a = Array<String?>(initCap){null}
    var n = 0
    var capacity = initCap

    public fun isEmpty(): Boolean {
        return (n == 0)
    }

    public fun size(): Int {
        return n
    }

    public fun resize(max: Int) {
        var temp = Array<String?>(max){null}
        a.copyInto(temp, startIndex = 0, endIndex = n)
        a = temp
        capacity = max
    }

    public fun push(item: String) {
        if (n == a.size) resize(2 * a.size)
        a[n++] = item
    }

    public fun pop(): String? {
        val item = a[--n]
        a[n] = null
        if ((n > 0) && (n == a.size / 4)) resize(a.size / 2)
        return item
    }

    override fun hasNext(): Boolean {
        return n >= 1
    }

    override fun next(): String? {
        return pop()
    }

    override fun toString(): String {
        return "${a.slice(0..n - 1).toString()}"
    }
}

fun main(args: Array<String>) {
    val s = DoublingStackOfString(1)

    while(!StdIn.isEmpty()) {
        val item = StdIn.readString()
        if (!item.equals("-")) {
            s.push(item)
            println("in <-: $item")
        } else if (!s.isEmpty()) {
            StdOut.println("out ->: ${s.pop()}")
        }
        println("stack(${s.size()}/${s.capacity}): $s")
    }
    StdOut.println("( " + s.size() + " left on stack)")

}