package ch01.s02.sample

public class StaticSetofInts(val keys: IntArray) {
    private var a = intArrayOf()
    init {
        a = keys
        a.sort()
    }

    public fun contains(key: Int): Boolean {
        return rank(key) != -1
    }

    private fun rank(key: Int): Int {
        var lo = 0
        var hi = a.size - 1
        while (lo <= hi) {
            var mid = lo + (hi - lo) / 2
            if (key < a[mid]) {
                hi = mid - 1
            } else if (key > a[mid]) {
                lo = mid + 1
            } else {
                return mid
            }
        }
        return -1
    }
}