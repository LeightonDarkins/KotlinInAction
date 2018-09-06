package chapterThree

import strings.*

fun main (args: Array<String>) {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1,7,53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    val strings = listOf("one", "two", "three")

    println(strings.last())

    val numbers = setOf(1,3,54)

    println(numbers.max())

    val someCollection = listOf(1,2,3)

    val stringOutput = joinToString(someCollection, separator = "; ", prefix = "(", postfix = ")")

    println(stringOutput)
    println(joinToString(someCollection))
    println(joinToString(someCollection, prefix = "$", postfix = "!!"))

    reportOperationCount()

    println("this is a test".last())

    val someStringCollection = listOf("1", "2", "3")

    println(someStringCollection.joinToStringExtension())
    println(someStringCollection.joinToStringExtension(separator = "; ", prefix = "[", postfix = "]"))

    val view = View()
    view.click()
    view.showOff()

    val button = Button()
    button.click()
    button.showOff()
}

