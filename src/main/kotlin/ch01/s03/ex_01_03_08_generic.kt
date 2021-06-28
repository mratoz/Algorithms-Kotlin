package ch01.s03

import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOut

class DoublingStack<T>(initCap: Int = 1): Iterator<T?> {
    var a: MutableList<T?> = MutableList<T?>(initCap) {null}
    var n = 0
    var capacity = initCap

    public fun isEmpty(): Boolean {
        return (n == 0)
    }

    public fun size(): Int {
        return n
    }

    public fun resize(max: Int) {
        var temp = MutableList<T?>(max){null}
        for ((idx, item) in a.slice(0..n-1).withIndex()) {
            temp[idx] = item
        }
        a = temp
        capacity = max
    }

    public fun push(item: T?) {
        if (n == a.size) resize(2 * a.size)
        a[n++] = item
    }

    public fun pop(): T? {
        val item = a[--n]
        a[n] = null
        if ((n > 0) && (n == a.size / 4)) resize(a.size / 2)
        return item
    }

    override fun hasNext(): Boolean {
        return n >= 1
    }

    override fun next(): T? {
        return pop()
    }

    override fun toString(): String {
        return "${a.slice(0..n - 1).toString()}"
    }
}

fun main(args: Array<String>) {
    val s = DoublingStack<String>(1)

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