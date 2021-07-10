package ch02.s01

import ch02.s01.sample.SelectionSort

fun main() {
    val s = "EASYQUESTION"
    val sa = s.split("").toTypedArray()
    SelectionSort.sort(s.split("").toTypedArray())
    println(sa.toString())

}