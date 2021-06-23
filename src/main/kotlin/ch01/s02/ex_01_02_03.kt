package ch01.s02

import edu.princeton.cs.algs4.*

fun main(args: Array<String>) {
    val n = args[0].toInt()
    val min = args[1].toDouble()
    val max = args[2].toDouble()

    StdDraw.setXscale(min, max)
    StdDraw.setYscale(min, max)

    var intersectCounter = 0
    var containCounter = 0

    val interval2DList = mutableListOf<Interval2D>()
    for (i in 1..n){
        val xInterval1D = getInterval1D(min, max)
        val yInterval1D = getInterval1D(min, max)
        interval2DList.add(Interval2D(xInterval1D, yInterval1D))
    }

    for (i in 0..n-1) {
        for (j in (i + 1)..n-1) {
            if (interval2DList[i].intersects(interval2DList[j])) {
                intersectCounter += 1
            }

            if (isInterval2DContained(interval2DList[i], interval2DList[j])) {
                containCounter += 1
            }
        }
    }

    println("number of intersect: ${intersectCounter}")
    println("number of contain: ${containCounter}")

    interval2DList.forEach({it.draw()})

}

fun getInterval1D(min: Double, max: Double): Interval1D {
    val a = StdRandom.uniform(min, max)
    val b = StdRandom.uniform(min, max)

    if (a > b) {
        return Interval1D(b, a)
    } else {
        return Interval1D(a, b)
    }
}

fun Interval2D.origin(): Pair<Interval1D, Interval1D> {
    val str = this.toString()
    val xStr = str.split("x")[0]
    val yStr = str.split("x")[1]
    val wboundArray = xStr.replace(Regex("[\\[\\]]"), "").split(",")
    val hboundArray = yStr.replace(Regex("[\\[\\]]"), "").split(",")
    return Pair(
        Interval1D(wboundArray[0].toDouble(), wboundArray[1].toDouble()),
        Interval1D(hboundArray[0].toDouble(), hboundArray[1].toDouble())
    )
}

fun isInterval2DContained(a: Interval2D, b: Interval2D): Boolean {
    return ((b.contains(Point2D(a.origin().first.min(), a.origin().second.min()))
                && b.contains(Point2D(a.origin().first.max(), a.origin().second.max()))
                )
        ||  (a.contains(Point2D(b.origin().first.min(), b.origin().second.min()))
                && a.contains(Point2D(b.origin().first.max(), b.origin().second.max()))
                )
            )
}
