package ch01.s02

/*
A string is a circular rotation of a string if it matches when the characters are circularly shifted by any number of
positions.
ACTGACG is circular shift of TGACGAC
Write program to check with given 2 strings s and t are circular shift of one another
*/

fun main(args: Array<String>) {
    val s = args[0]
    val t = args[1]

    val isCircularRotate  = fun(s: String, t: String): Boolean {return (s.length == t.length) && (s + s).contains(t)}

    println("$s and $t is circular retated string pair: ${isCircularRotate(s, t)}")

}




