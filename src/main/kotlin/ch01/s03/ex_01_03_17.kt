package ch01.s03

import ch01.s03.sample.Queue
import edu.princeton.cs.algs4.In


private class Transaction(s: String) {
    lateinit var customer: String
    lateinit var date: Date
    var amount: Double = 0.0

    init {
        val a = s.split(" ")
        customer = a[0]
        date = Date(a[1])
        amount = a[2].toDouble()
    }

    companion object {
        fun readTransactions(name: String): Array<Transaction?> {
            val inData = In(name)
            val q = Queue<Transaction>()

            while(!inData.isEmpty) {
                val transaction = Transaction(inData.readLine())
                q.enqueue(transaction)
            }

            val arrayOfTransaction = Array<Transaction?>(q.size()) {null}
            for (i in 0..arrayOfTransaction.size - 1) {
                arrayOfTransaction[i] = q.dequeue()
            }

            return arrayOfTransaction
        }
    }

    override fun toString(): String {
        return "$customer $date $amount"
    }
}

fun main(args: Array<String>) {
    println("read from first file: ")
    val file = args[0]
    val res = Transaction.readTransactions(file)
    for (item in res) {
        println(item)
    }

}