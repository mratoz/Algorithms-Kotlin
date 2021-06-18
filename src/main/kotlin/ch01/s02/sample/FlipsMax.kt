package ch01.s02.sample

import lib.Counter
import lib.StdRandom

fun max(x: Counter, y: Counter): Counter {
    return if (x.tally() > y.tally()) x else y
}

fun main(args: Array<String>) {
    val t: Int = args[0].toInt()
    val heads: Counter = Counter("headers")
    val tails: Counter = Counter("tails")
    for (i in 1..t) {
        if (StdRandom.bernoulli(0.5)) {
            heads.increment()
        }
        else {
            tails.increment()
        }
    }

    println(if (heads.tally() == tails.tally()) "Tie" else max(heads, tails).toString() + " wins")
}