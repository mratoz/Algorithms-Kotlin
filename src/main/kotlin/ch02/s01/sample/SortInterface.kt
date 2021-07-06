package ch02.s01.sample

interface SortInterface {
    fun <T: Comparable<T>> sort(a: Array<T>): Unit
    fun <T: Comparable<T>> less(v: T, w: T): Boolean
    fun <T: Comparable<T>> exch(a: Array<T>, i: Int, j: Int): Unit
    fun <T: Comparable<T>> show(a: Array<T>): Unit
    fun <T: Comparable<T>> isSorted(a: Array<T>): Boolean
}