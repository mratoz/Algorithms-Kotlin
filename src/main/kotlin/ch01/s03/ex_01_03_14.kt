package ch01.s03

class ResizingArrayQueueOfStrings(val cap: Int = 1) {
    var a: Array<String> = Array<String>(cap){ "" }
    var first: Int = 0
    var last: Int = 0

    fun isEmpty(): Boolean {
        return first == last
    }

    fun size(): Int {
        return last - first
    }

    fun enqueue(item: String) {
        if (last >= a.size - 1) {
            resize(a.size * 2)
        }
        a[last] = item
        last += 1
    }

    fun dequeue(): String {
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
        val tmp = Array<String>(newCap) {""}
        var i = 0
        for (item in a.sliceArray(first..last)) {
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
    val q = ResizingArrayQueueOfStrings(n)
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
}