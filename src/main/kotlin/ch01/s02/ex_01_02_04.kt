package ch01.s02

fun main(args: Array<String>) {
    var string1 = "hello"
    var string2 = string1

    string1 = "world"
    println(string1)
    println(string1.hashCode())
    println(string2)
    println(string2.hashCode())
}