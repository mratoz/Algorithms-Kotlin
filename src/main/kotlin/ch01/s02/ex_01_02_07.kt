package ch01.s02

fun main(args: Array<String>) {
    val a = "1234567"
    val b = "abcdefgh"

    println("$a after mystery processing: ${mystery(a)}")
    println("$b after mystery processing: ${mystery(b)}")

}

fun mystery(s: String): String {
    val n: Int = s.length
    if(n <= 1) return s
    val a = s.substring(0, n/2)
    val b = s.substring(n/2, n)
    return mystery(b) + mystery(a)
}