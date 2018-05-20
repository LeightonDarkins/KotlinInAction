package chapterTwo

fun main(args: Array<String>) {
    println(min(1, 5))
    println(min(3, 1))
    println(min(-4, -8))
    println(min(10, 2))
}

fun min(num1: Int, num2: Int): Int = if (num1 < num2) num1 else num2