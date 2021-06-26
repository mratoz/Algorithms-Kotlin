package ch01.s03.sample

import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOut

public class Stack<T>{
    class Node<T>(val item: T, var next: Node<T>? = null)

    var first: Node<T>? = null
    var n: Int = 0

    public fun isEmpty(): Boolean {
        return first == null
    }

    public fun size(): Int {
        return n
    }

    val psize: Int
        get() = this.n

    public fun push(item: T): Unit {
        val oldFirst = first
        first = Node(item, oldFirst)
        n++
    }

    public fun pop(): T {
        val item = first!!.item
        first = first!!.next
        n--
        return item
    }
}

fun main(args: Array<String>) {
    val s = Stack<String>()

    while(!StdIn.isEmpty()) {
        val item = StdIn.readString()
        if (!item.equals("-")) {
            s.push(item)
        } else if (!s.isEmpty()) {
            val str: String = s.pop()
            StdOut.print(str + " ")
        }
    }
    StdOut.println("( " + s.size() + " left on stack)")
}