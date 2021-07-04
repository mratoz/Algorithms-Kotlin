package ch01.s04.sample

class TwoSum {
    companion object {
        fun count(a: IntArray): Int {
            val n = a.size
            var cnt = 0
            for (i in 0..n-1) {
                for (j in i+1..n-1) {
                    if( a[i] + a[j] == 0){
                       cnt += 1
                    }
                }
            }
            return cnt
        }
    }
}