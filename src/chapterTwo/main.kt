package chapterTwo

fun main(args: Array<String>) {
    println("hello world!")

    val ben = Person("Ben", true)
    val square = Rectangle(5,5)
    val rectangle = Rectangle(10,5)

    println("Is ${ben.name} married? ${ben.isMarried}")
    println("This is a square: ${square.isSquare}")
    println("This is uneven: ${rectangle.isSquare}")
}