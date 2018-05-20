package chapterTwo

import java.io.BufferedReader
import java.io.StringReader

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("123"))

    println(readNumber(reader))

    val differentReader = BufferedReader(StringReader("123"))
    val brokenReader = BufferedReader(StringReader("not a numbers"))

    readNumberWithTryExpression(differentReader)
    readNumberWithTryExpression(brokenReader)
}

fun readNumber(reader: BufferedReader): Int? {
    // regular ol' java try catch, nothing special here
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

fun readNumberWithTryExpression(reader: BufferedReader) {
    // a try block can be an expression that gives a result, to be returned to the caller
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    } finally {
        reader.close()
    }

    println(number)
}