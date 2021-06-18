package ch01.s02.sample

import lib.Counter
import lib.StdRandom

fun main(args: Array<String>) {
    val t: Int = args[0].toInt()
    val sides = 6
    val rolls = Array<Counter>(sides + 1){ i -> Counter(i.toString() + "'s") }

    for (i in 1..t) {
        val result = StdRandom.uniform(1, sides + 1)
        rolls[result].increment()
    }

    for (i in 1..sides) {
        println(rolls[i])
    }
}