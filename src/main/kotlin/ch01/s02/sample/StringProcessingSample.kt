package ch01.s02.sample

fun isPalindrome(s: String): Boolean {
    val n: Int = s.length
    for (i in 0..(n/2)) {
        println("${s[i]} compare with ${s[n - 1 - i]}")
        if (s[i] != s[n - 1 - i]){
            return false
        }
    }
    return true
}

fun isSorted(aOS: Array<String>): Boolean {
    for (i in 1..aOS.size - 1) {
        if (aOS[i] < aOS[i - 1]) {
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    val word1 = "abcddcba"
    val word2 = "hello"
    val wordList = arrayOf<String>(word1, word2, "abc")
    println("word list is ${wordList.joinToString(",")}")
    for (word in wordList) {
        println("$word is Palindrome: ${isPalindrome(word)}")
    }

    println("The wordlist is sorted: ${isSorted(wordList)}")
}
