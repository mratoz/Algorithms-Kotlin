package ch01.s03

import ch01.s03.sample.Queue
import edu.princeton.cs.algs4.In

private class Date(val s:String) {
    private var m: Int = 0
    private var d: Int = 0
    private var y: Int = 1900

    init {
        var sa = s.split("/")
        m = sa[0].toInt()
        d = sa[1].toInt()
        y = sa[2].toInt()
    }

    companion object {
        fun readDates(name: String): Array<Date?> {
            val inData = In(name)
            val q = Queue<Date>()

            while (!inData.isEmpty) {
                q.enqueue(Date(inData.readString()))
            }

            val arrayOfDate = Array<Date?>(q.size()) { null }
            for (i in 0..arrayOfDate.size-1) {
                arrayOfDate[i] = q.dequeue()
            }

            return arrayOfDate
        }
    }

    fun month(): Int {
        return m
    }

    fun day(): Int {
        return d
    }

    fun year(): Int {
        return y
    }

    override fun toString(): String {
        return "${month()}/${day()}/${year()}"
    }
}


fun main(args: Array<String>) {
    println("read from first file: ")
    val file = args[0]
    val res = Date.readDates(file)
    for (item in res) {
        println(item)
    }

    println("read from second file:")
    val file2 = args[1]
    val res2 = Date.readDates(file2)
    for (item in res2) {
        println(item)
    }
}
