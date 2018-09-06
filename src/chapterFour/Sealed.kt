package chapterFour

// sealed classes can only be extended by subclasses defined within themselves
// sealed also implies that the class is "open"
sealed class Expression {
    class Num(val value: Int) : Expression()
    class Sum(val left: Expression, val right: Expression) : Expression()
//    adding the following line will cause the compiler to complain about the "when" expression below
//    class Drum(val banana: Expression) : Expression()
}

// "when" expressions MUST be exhaustive, if all subclass possibilities aren't handled, this code will not compile
fun evaluateExpression(e: Expression): Int =
    when (e) {
        is Expression.Num -> e.value
        is Expression.Sum -> evaluateExpression(e.right) + evaluateExpression(e.left)
        is ReturnOne -> 1
    }

// kotlin 1.1 allows sealed classes to be extended by subclasses defined in the same file
class ReturnOne(val fruit: Expression): Expression()