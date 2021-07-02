package ch01.s03

import ch01.s03.sample.Stack
import edu.princeton.cs.algs4.StdOut

fun <T> Stack<T>.copy(): Stack<T> {
    val new = Stack<T>()
    for (item in this) {
        new.push(item)
    }
    return new
}

fun main(args: Array<String>) {
    val old = Stack<String>()
    old.push("a")
    old.push("b")
    old.push("c")
    val new = old.copy()
    println("old: $old")
    println("new after copy: $new")
    new.push("d")
    println("old: $old")
    println("new after push: $new")
}