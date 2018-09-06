package chapterThree

import strings.lastChar
import strings.firstChar as first

// extend collection with a joinToString function
fun <T> Collection<T>.joinToString(separator:String = ", ", prefix:String = "", postfix:String = ""): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

var StringBuilder.finalChar: Char
    get() = get(length - 1)
    set(value: Char) {
        setCharAt(length - 1, value)
    }

fun main (args: Array<String>) {
    println("last".lastChar())
    println("last".first())

    val list = listOf("1", "2", "3")

    println(list.joinToString(prefix = "%%%%", postfix = "***"))
    val sb = StringBuilder("Kotlin!")

    println(sb)

    sb.finalChar = '?'

    println(sb)
}