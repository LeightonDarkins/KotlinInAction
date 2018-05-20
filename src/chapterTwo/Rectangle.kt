package chapterTwo

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }

    val isUneven: Boolean
        get() = height != width
}

fun main(args: Array<String>) {
    val square = Rectangle(5,5)
    val rectangle = Rectangle(10, 5)

    println(square.isSquare)
    println(square.isUneven)

    println(rectangle.isSquare)
    println(rectangle.isUneven)
}