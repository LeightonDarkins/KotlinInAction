fun main(args: Array<String>) {
    println(max(1, 5))
    println(max(3, 1))
    println(max(-4, -8))
    println(max(10, 2))
}

fun max(num1: Int, num2: Int):Int {
    return if (num1 > num2) num1 else num2
}