package chapterTwo

fun main(args: Array<String>) {
    println("Multiply")
    println(multiply(1, 2))
    println(multiply(2, 2))
    println(multiply(3, 2))
    println(multiply(4, 2))

    println("Divide")
    println(divide(1, 2))
    println(divide(2, 2))
    println(divide(3, 2))
    println(divide(4, 2))
}

fun multiply(num1: Int, num2: Int) = num1 * num2

// must include a return type for Block Body functions
fun divide(num1: Int, num2: Int): Int {
    return num1 / num2
}