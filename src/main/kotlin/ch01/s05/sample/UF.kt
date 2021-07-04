package ch01.s05.sample

import edu.princeton.cs.algs4.StdIn

class UF(val N: Int) {
    private var count = N
    private val id = IntArray(N)

    init {
        for (i in 0..N-1) {
            id[i] = i
        }
    }

    fun count(): Int {
        return count
    }

    fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    fun find(p: Int): Int {
        return id[p]
    }

    fun union(p: Int, q: Int): Unit {
        val pID = find(p)
        val qID = find(q)

        if (pID == qID) return

        for (i in 0..N-1) {
            if (id[i] == pID) id[i] = qID
        }

        count--
    }

}

fun main(args: Array<String>) {
    val N = StdIn.readInt()
    val uf = UF(N)

    while (!StdIn.isEmpty()) {
        val p = StdIn.readInt()
        val q = StdIn.readInt()

        if (uf.connected(p, q)) {
            continue
        } else {
            uf.union(p, q)
        }

        println("$p $q")
    }

    println("${uf.count()} components")
}