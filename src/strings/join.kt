
// annotate with a new name for use in java

@file:JvmName("StringFunctions")

package strings

// top level properties
var opCount = 0
// private static final equiv
const val UNIX_LINE_SEPARATOR = "\n"

// equiv to "public static final"
const val CONSTANT_VALUE = '\n'

fun reportOperationCount(){
    println("Operation Performed $opCount times")
}

fun <T> joinToString(collection: Collection<T>, separator: String = ", ", prefix: String = "(", postfix: String = ")"): String {
    opCount++

    val result = StringBuilder(prefix)

    for((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)

        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

// extension functions

// extend String class with a lastChar method
fun String.lastChar(): Char = this.get(this.length - 1)

// "this" can be omitted in extension functions
fun String.firstChar(): Char = get(0)

// use in JAVA

// char c = StringFunctions.lastChar("string")
// c is now equal to "g"

fun Collection<String>.joinToStringExtension(
        separator: String = ", ",
        prefix: String = "(",
        postfix: String = ")"): String {
    val result = StringBuilder(prefix)

    for((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)

        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

open class View {
    open fun click() = println("view clicked!")
}

class Button: View() {
    override fun click() = println("button clicked!")
}

fun View.showOff() {
    println("I'm a view!")
}