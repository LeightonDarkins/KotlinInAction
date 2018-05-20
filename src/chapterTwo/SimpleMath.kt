package chapterTwo

import kotlin.math.exp

interface Expression
class Num(val value: Int) : Expression
class Sum(val left: Expression, val right: Expression) : Expression

fun main(args: Array<String>) {
    // expression = (1 + 2) + 4
    val expression = Sum(Sum(Num(1), Num(2)), Num(4))

    println(evaluate(expression))
    println(evaluateWithKotlinIf(expression))
    println(evaluateWithWhen(expression))
    println(evaluateWithWhenAndLogging(expression))
}

fun evaluate (expression: Expression): Int {
    // the compiler casts the expression to the checked value automatically
    // i.e. if expression is a Num, the expression is now a Num, no need for a cast
    if (expression is Num) return expression.value

    if (expression is Sum) return evaluate(expression.left) + evaluate(expression.right)

    throw IllegalArgumentException("Unknown Expression")
}

fun evaluateWithKotlinIf (expression: Expression) =
    if (expression is Num) {
        expression.value
    } else if (expression is Sum) {
        evaluate(expression.left) + evaluate(expression.right)
    } else {
        throw IllegalArgumentException("Unknown Expression")
    }

fun evaluateWithWhen (expression: Expression): Int =
    when (expression) {
        is Num -> expression.value
        is Sum -> evaluateWithWhen(expression.left) + evaluateWithWhen(expression.right)
        else -> throw IllegalArgumentException("Unknown Expression")
    }

fun evaluateWithWhenAndLogging (expression: Expression): Int =
    when (expression) {
        is Num -> {
            println("Num: ${expression.value}")

            // the last line in this block is implicitly returned
            expression.value
        }

        is Sum -> {
            val left = evaluateWithWhenAndLogging(expression.left)
            val right = evaluateWithWhenAndLogging(expression.right)

            println("Sum: $left + $right")

            // the last line in this block is implicitly returned
            left + right
        }

        else -> throw IllegalArgumentException("Unknown Expression")
    }