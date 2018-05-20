package chapterTwo

// JAVA

//public class chapterTwo.Person {
//    private final String name;
//    private final Boolean isMarried;
//
//    public chapterTwo.Person(String name, Boolean isMarried) {
//        this.name = name;
//        this.isMarried = isMarried
//    }
//
//    public getName() {
//        return this.name;
//    }

//    public isMarried() {
//        retrun this.isMarried;
//    }
//}

// KOTLIN

// create a class called chapterTwo.Person with an IMMUTABLE VALUE, name
// and a VARIABLE: isMarried.

class Person(val name:String, var isMarried:Boolean)

fun main(args: Array<String>) {
    val steve = Person("Steve", true)
    val matt = Person("Matt", false)
    val larene = Person("Larene", false)

    println("Is ${steve.name} married? ${steve.isMarried}")
    println("Is ${matt.name} married? ${matt.isMarried}")
    println("Is ${larene.name} married? ${larene.isMarried}")

    // cannot reassign name, it's an IMMUTABLE VALUE
    // matt.name = "Jimmy"

    // can reassign isMarried, it's a VARIABLE
    matt.isMarried = true
    larene.isMarried = false

    println("Is ${steve.name} married? ${steve.isMarried}")
    println("Is ${matt.name} married? ${matt.isMarried}")
    println("Is ${larene.name} married? ${larene.isMarried}")
}