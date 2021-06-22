package ch01.s02

import edu.princeton.cs.algs4.Point2D
import edu.princeton.cs.algs4.StdRandom

fun main(args: Array<String>) {
    val n: Int = args[0].toInt()
    val pointList: Array<Point2D> = Array<Point2D>(n, { Point2D(StdRandom.uniform(), StdRandom.uniform()) })

    pointList.forEach { it.draw() }

    var minDistance:Double = Double.MAX_VALUE
    var minA: Point2D = Point2D(Double.MIN_VALUE, Double.MIN_VALUE)
    var minB: Point2D = Point2D(Double.MAX_VALUE, Double.MAX_VALUE)


    for (i in 0..n-1) {
        for (j in (i+1)..n-1){
            val distance = pointList[i].distanceTo(pointList[j])
            if (distance < minDistance) {
                minDistance = distance
                minA = pointList[i]
                minB = pointList[j]
            }
        }
    }

    minA.drawTo(minB)
    println("Min distance is: $minDistance")
}