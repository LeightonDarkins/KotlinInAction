package chapterThree

fun main(args: Array<String>) {
    // destructure arrays with * to pass the values to a method that accepts "varargs"
    val firstList = listOf("a", *args)

    println(firstList)
}