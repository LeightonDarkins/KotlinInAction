package chapterTwo

fun main(args: Array<String>) {
    // this creates a range from the first number to the last number (including the last number)
    // val oneToTen = 1..10

    // simple fizzBuz implementation
    // for(i in 1..100) {
    //  println(fizzBuzz(i))
    //  }

    // 10 to 1, only every second number
    for(i in 10 downTo 1 step 2) {
        println(i)
    }

    // 0 to 9 (10 - 1)
    for(i in 0 until 10) {
        println(i)
    }
}

fun fizzBuzz(number: Int) =
    when {
        number % 15 == 0 -> "FizzBuzz"
        number % 3 == 0 -> "Fizz "
        number % 5 == 0 -> "Buzz "
        else -> "$number "
    }