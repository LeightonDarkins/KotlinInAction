package chapterThree

// how to create a map
// how to destructure maps

fun main(args: Array<String>) {
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")

    println(map)

    // destructuring a map
    val (number, name) = 1 to "one"

    println(number)
    println(name)

    val (numeral, string) = map.entries.first()

    println(numeral)
    println(string)

    val withIndex = listOf(1,2,3).withIndex().first()
    val (value, index) = withIndex

    println(value)
    println(index)
}