package chapterTwo

import java.util.*

fun main(args: Array<String>) {
    val binaryReps = TreeMap<Char, String>()

    // create a range of letters
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())

        binaryReps[c] = binary
    }

    // de-structure both key and value from a map
    for((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    // iterate whilst tracking index
    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index = $element")
    }

    println("is Y a letter? ${isLetter('Y')}")
    println("is G not number? ${isNotDigit('G')}")

    // any comparable class can be used in ranges
    // in this case, the "in" is determined alphabetically
    val stringRange = "Java".."Scala"
    println("Is Kotlin between Java and Scala? ${"Kotlin" in stringRange}")

    // "in" can also be used with sets, but it checks membership of the set
    val stringSet = setOf("Java", "Scala")
    println("Is Kotlin between Java and Scala? ${"Kotlin" in stringSet}")
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'