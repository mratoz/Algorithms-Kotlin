package ch01.s02.sample

import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.Out

fun main(args: Array<String>) {
    val out: Out = Out(args[args.size - 1])
    for (arg in args.slice(0..(args.size - 2))) {
        println(arg)
        val inf: In = In(arg)
        val s = inf.readAll()
        out.println(s)
        inf.close()
    }
    out.close()
}