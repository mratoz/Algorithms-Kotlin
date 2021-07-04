package ch01.s04.sample

import edu.princeton.cs.algs4.StdRandom

class DoublingRatio {
    companion object {
        fun timeTrial(n: Int): Double{
            val MAX = 1_000_000
            var a: IntArray = IntArray(n)

            for (i in 0..n-1) {
                a[i] = StdRandom.uniform(-MAX, MAX)
            }

            val timer = Stopwatch()
            val cnt = ThreeSumFast.count(a)
            return timer.elapsedTime()
        }
    }
}

/*
ThreeSum:
250 0.005 1.6666666666666667
500 0.025 5.0
1000 0.1 4.0
2000 0.898 8.98
4000 6.257 6.967706013363029
8000 49.815 7.961483138884449
 */

/*
ThreeSumFast:
250 0.003 0.27272727272727276
500 0.005 1.6666666666666667
1000 0.019 3.8
2000 0.061 3.210526315789474
4000 0.256 4.19672131147541
8000 1.099 4.29296875
16000 4.624 4.207461328480437
32000 19.329 4.18014705882353
 */

fun main(args: Array<String>) {
    var prev = DoublingRatio.timeTrial(125)
    var n = 250

    while (true){
        val time = DoublingRatio.timeTrial(n)
        println("$n $time ${time/prev}")
        n += n
        prev = time
    }
}