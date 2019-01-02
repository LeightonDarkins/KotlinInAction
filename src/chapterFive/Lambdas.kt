package chapterFive

import chapterThree.joinToString

data class LambdaPerson(val name: String, val age: Int)

fun findTheOldest(people: List<LambdaPerson>) {
    var maxAge = 0
    var theOldest: LambdaPerson? = null

    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }

    println(theOldest)
}

fun main (args: Array<String>) {
    val people = listOf(LambdaPerson("Alice", 29), LambdaPerson("Bob", 31))

    // three implementations of finding the oldest person in a list

    // use a custom function
    findTheOldest(people)

    // use a lambda
    // "it" refers to the item in the list
    // don't abuse "it"
    println(people.maxBy { it.age })

    // use a member property where the lambda logic is simple
    // Class::Member
    println(people.maxBy(LambdaPerson::age))

    // lambda syntax
    // { x: Type, y: Type -> x + y }

    // store lambda as variable, call like a regular function
    // when storing lambdas as variables, always specify types, as there's no way for the compiler to infer them
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))

    // execute a lambda directly
    run { println(42) }

    // be specific about type instead of "it"
    println(people.minBy { person: LambdaPerson -> person.age })

    // pass lambda as argument to a function
    val names = people.joinToString(separator = " ", transform = { p: LambdaPerson -> p.name })
    println(names)

    // remove type specificity from minBy lambda - the compiler knows what type you're working with
    // Kotlin convention: start without types, add them if the compiler complains
    println(people.minBy { person -> person.age })

    // lambdas can be longer than a single line or statement
    val multilineSum = { x:Int, y:Int ->
        println("Doing the multiline sum")

        x + y
    }

    println(multilineSum(3,4))

    // Lambdas can access variables when they're defined in the same scope
    // in this case, a function
    fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
        val thing: String = "test"

        messages.forEach {
            // "prefix" is defined outside of this lambda, but is accessible here
            // so is "thing"
            println("$prefix $it $thing")
        }
    }

    val messages = listOf("404 Not Found", "403 Forbidden")

    printMessagesWithPrefix(messages, "Error:")

    // another example of variable scope with lambdas
    fun printProblemCounts(responses: Collection<String>) {
        var clientErrors = 0
        var serverErrors = 0
        // both of these vars are accessible within the forEach lambda

        responses.forEach {
            if (it.startsWith("4")) {
                clientErrors++
            } else if (it.startsWith("5")) {
                serverErrors++
            }
        }

        println("$clientErrors client errors. $serverErrors server errors")
    }

    val responses = listOf("200 OK", "418 I'm A Teapot", "500 Internal Server Error")
    printProblemCounts(responses)

    //
    fun salute() = println("Salute!")
    run(::salute)
}