package ch01.s03

class ResizingArrayQueue<T>(val cap: Int = 1) {
    var a: MutableList<T?> = MutableList<T?>(cap) { null }
    var first: Int = 0
    var last: Int = 0

    fun isEmpty(): Boolean {
        return first == last
    }

    fun size(): Int {
        return last - first
    }

    fun enqueue(item: T?) {
        if (last >= a.size - 1) {
            resize(a.size * 2)
        }
        a[last] = item
        last += 1
    }

    fun dequeue(): T? {
        val item = a[first]
        first += 1
        if (this.size() <= a.size / 4 && a.size / 4 > 0) {
            resize(a.size/2)
            last = last - first
            first = 0
        }
        return item
    }

    fun resize(newCap: Int) {
        println("resize from ${a.size} to $newCap")
        val tmp = MutableList<T?>(newCap) { null }
        var i = 0
        for (item in a.slice(first..last)) {
            tmp[i++] = item
        }
        a = tmp
    }

    override fun toString(): String {
        return a.joinToString(",")
    }
}

fun main(args: Array<String>) {
    val n = 4
    val q = ResizingArrayQueue<String>(n)
    q.enqueue("a")
    println(q)
    q.enqueue("b")
    println(q)
    q.enqueue("c")
    println(q)
    q.enqueue("d")
    println(q)
    println("queue size: ${q.size()}")
    println("dequeue: " + q.dequeue())
    println("")
    println("dequeue: " + q.dequeue())
    println("")
    println("queue empty now?: ${q.isEmpty()}")
    println("dequeue: " + q.dequeue())
    println("")
    println("queue empty now?: ${q.isEmpty()}")
    println("dequeue: " + q.dequeue())
    println("")
    println("queue empty now?: ${q.isEmpty()}")

    val q1 = ResizingArrayQueue<Int>()
    q1.enqueue(0)
    println(q1)
    q1.enqueue(1)
    println(q1)
    q1.enqueue(2)
    println(q1)
    q1.enqueue(3)
    println(q1)
    println("queue size: ${q1.size()}")
    println("dequeue: " + q1.dequeue())
    println("")
    println("dequeue: " + q1.dequeue())
    println("")
    println("queue empty now?: ${q1.isEmpty()}")
    println("dequeue: " + q1.dequeue())
    println("")
    println("queue empty now?: ${q1.isEmpty()}")
    println("dequeue: " + q1.dequeue())
    println("")
    println("queue empty now?: ${q1.isEmpty()}")

}