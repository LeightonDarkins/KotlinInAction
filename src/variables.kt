fun main(args: Array<String>) {
    // cannot be reassigned
    // type declaration optional
    val one:Int = 1
    val two = 2

    // can be reassigned
    // type declaration optional
    var string:String = "a string"
    var anotherString = "another string"

    // must include type declaration
    var double:Double
    double = 20.02
    // cannot assign a different type
    // double = 20.02f
    // double = "double"

    // must include type declaration
    val float:Float
    float = 10.10f

    // String Templates

    // escape $
    println("\$$double")

    // even double quotes can nest as long as they're in an expression
    println("${"test"}")

    println("one: ${one.javaClass.name}")
    println("two: ${two.javaClass.name}")
    println("string: ${string.javaClass.name}")
    println("anotherString: ${anotherString.javaClass.name}")
    println("double: ${double.javaClass.name}")
    println("float: ${float.javaClass.name}")
}