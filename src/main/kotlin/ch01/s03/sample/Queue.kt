package ch01.s03.sample

import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOut

public class Queue<T> {
    class Node<T>(val item: T, var next: Node<T>? = null )

    private var first: Node<T>? = null
    private var last: Node<T>? = null
    private var n: Int = 0

    public fun isEmpty(): Boolean {
        return n == 0
    }

    public fun size(): Int {
        return n
    }

    public fun enqueue(item: T): Unit {
        val oldLast = last
        last = Node(item, null)
        // For first element enqueue: both first and last is null,
        // we only need to make first last point to the same node
        if (n == 0) {
            first = last
        } else {
            oldLast!!.next = last
        }
        n++
    }

    public fun dequeue(): T {
        val oldFirst = first!!
        first = oldFirst.next
        // For last element deque: first is set to null with above action
        // we need to make last point to null as initial empty queue
        if (n == 0) last = null
        n--
        return oldFirst.item
    }

}

fun main(args: Array<String>) {
    val s = Queue<String>()

    while(!StdIn.isEmpty()) {
        val item = StdIn.readString()
        if (!item.equals("-")) {
            s.enqueue(item)
        } else if (!s.isEmpty()) {
            val str: String = s.dequeue()
            StdOut.print(str + " ")
        }
    }
    StdOut.println("( " + s.size() + " left on stack)")
}
