package ch01.s02.sample

import edu.princeton.cs.algs4.StdDraw
import edu.princeton.cs.algs4.StdRandom

class VisualAccumulator constructor(val trails: Int, val max: Double) {
    private var total: Double = 0.0
    private var n: Int = 0

    init {
        StdDraw.setXscale(0.0, trails.toDouble())
        StdDraw.setYscale(0.0, max)
        StdDraw.setPenRadius(.005)
    }

    public fun addDataValue(v: Double): Unit {
        n++
        total += v
        StdDraw.setPenColor(StdDraw.DARK_GRAY)
        StdDraw.point(n.toDouble(), v)
        StdDraw.setPenColor(StdDraw.RED)
        StdDraw.point(n.toDouble(), total/n)
    }

    public fun mean(): Double {
        return total/n
    }

    public override fun toString(): String {
        return "Mean (${n}) values: ${mean()}"
    }
}

fun main(args: Array<String>) {
    val t: Int = args[0].toInt()
    val a: VisualAccumulator = VisualAccumulator(t, 1.0)
    for (i in 1..t) {
        a.addDataValue(StdRandom.uniform())
    }
    println(a)
}