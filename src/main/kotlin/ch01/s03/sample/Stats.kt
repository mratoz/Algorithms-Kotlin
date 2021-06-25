package ch01.s03.sample

import edu.princeton.cs.algs4.Bag
import edu.princeton.cs.algs4.StdIn
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val numbers: Bag<Double> = Bag()

    while(!StdIn.isEmpty()) {
        numbers.add(StdIn.readDouble())
    }

    val n = numbers.size()

    var sum: Double = 0.0
    for (num in numbers) {
        sum += num
    }
    val mean = sum / n

    sum = 0.0
    for (num in numbers) {
        sum += (num - mean) * (num - mean)
    }
    val std = sqrt(sum / (n - 1))

    println("Mean: ${mean}")
    println("Std dev: ${std}")
}