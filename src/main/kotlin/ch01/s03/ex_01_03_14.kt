package ch01.s03

class ResizingArrayQueueOfStrings(val n: Int = 1) {
    val a: Array<String> = Array<String>(n){ "" }
    var first: Int = 0
    var last: Int = 0

    fun isEmpty(): Boolean {
        return first == last
    }

    fun size(): Int {
        return last - first
    }

    fun enqueue(item: String) {
        a[last] = item
        last += 1
    }

    fun dequeue(): String {
        val item = a[first]
        first += 1
        return item
    }
}

fun main(args: Array<String>) {
    val n = 5
    val q = ResizingArrayQueueOfStrings(n)
    q.enqueue("a")
    q.enqueue("b")
    q.enqueue("c")
    println("queue size: ${q.size()}")
    println(q.dequeue())
    println(q.dequeue())
    println("queue empty now?: ${q.isEmpty()}")
    println(q.dequeue())
    println("queue empty now?: ${q.isEmpty()}")
}