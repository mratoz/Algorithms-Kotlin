package ch01.s02

import edu.princeton.cs.algs4.Counter
import kotlin.math.abs

private class VisualCounter(val name: String, val N: Int, val max: Int) {
    private var operations = 0
    private var count = 0

    public fun increment(): Unit {
        if (operations < N && abs(count) < max) {
            count += 1
            operations += 1
        }
    }

    public fun decrement(): Unit {
        if (operations < N && abs(count) < max){
            count -= 1
            operations += 1
        }
    }

    public fun tally(): Int {
        return count
    }

    public override fun toString(): String {
        return "${count}/${max} $name($operations/$N)"
    }
}

// it's impossible to use subclassing for this exercise as the count property of Counter is private and parent class
// Counter doesn't provide API which can be used to implement decrement. Really vivid example for subclassing

//private class VisualCounter1(val name: String, val N: Int, val max: Int): Counter(name) {
//    private var operations = 0
//
//    override fun increment() {
//        if (operations < N && abs(this.tally()) < max) {
//            super.increment()
//            operations += 1
//        }
//    }
//
//    public fun decrement(): Unit {
//
//    }
//}

fun main(args: Array<String>) {
    val a = VisualCounter("a", 3, 2)
    a.increment()
    println(a)
    a.increment()
    println(a)
    a.increment()
    println(a)
}