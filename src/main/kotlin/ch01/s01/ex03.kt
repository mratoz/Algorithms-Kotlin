package ch01.s01


fun main(args: Array<String>) {
    val a: Int = args[0].toInt()
    val b: Int = args[1].toInt()
    val c: Int = args[2].toInt()
    println("first arg: $a, second arg: $b, third arg: $c")

    if (a == b && a == c) {
        println("equal")
    }
    else {
        println("not equal")
    }
}
