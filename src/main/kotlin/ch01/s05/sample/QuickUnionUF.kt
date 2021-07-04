package ch01.s05.sample

import edu.princeton.cs.algs4.StdIn

class QuickUnionUF(N: Int) {
    val id: IntArray = IntArray(N)
    var count = N

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
        var pl = p
        while (pl != id[pl]) pl=id[pl]
        return pl
    }

    fun union(p: Int, q: Int): Unit {
        val pRoot = find(p)
        val qRoot = find(q)

        // if p, q are already connected, they share same root
        // and just return without furhter operation
        if (pRoot == qRoot) return

        id[pRoot] = qRoot
        count--
    }
}

fun main(args: Array<String>) {
    val N = StdIn.readInt()
    val uf = QuickUnionUF(N)

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