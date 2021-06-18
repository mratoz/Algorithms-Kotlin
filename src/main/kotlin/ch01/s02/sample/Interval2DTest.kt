package ch01.s02.sample

import edu.princeton.cs.algs4.Counter
import edu.princeton.cs.algs4.Interval1D
import edu.princeton.cs.algs4.Interval2D
import edu.princeton.cs.algs4.StdRandom
import edu.princeton.cs.algs4.Point2D

fun main(args: Array<String>) {
    val xlo: Double = args[0].toDouble()
    val xhi: Double = args[1].toDouble()
    val ylo: Double = args[2].toDouble()
    val yhi: Double = args[3].toDouble()
    val t = args[4].toInt()

    val xinterval: Interval1D =
        Interval1D(xlo, xhi)
    val yinterval: Interval1D =
        Interval1D(ylo, yhi)

    val box: Interval2D = Interval2D(xinterval, yinterval)
    box.draw()

    val counter: Counter =
        Counter("hits")

    for (i in 0..t-1) {
        val x = StdRandom.random()
        val y = StdRandom.random()
        val p = Point2D(x, y)

        if (box.contains(p)) counter.increment() else p.draw()

        println(counter)
        println("box area ${box.area()}")
    }
}