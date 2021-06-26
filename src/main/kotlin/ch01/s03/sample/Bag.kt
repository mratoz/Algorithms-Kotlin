package ch01.s03.sample

public class Bag<T> {
    class Node<T>(val item: T, var next: Node<T>? = null)

    private var first: Node<T>? = null
    private var n: Int = 0

    public fun isEmpty(): Boolean {
        return first == null
    }

    public fun size(): Int {
        return n
    }

    public fun add(item: T): Unit {
        val oldFirst = first
        first = Node(item, oldFirst)
    }
}
