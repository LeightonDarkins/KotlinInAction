package chapterFour.CompanionObjects

// Kotlin doesn't have a "static" keyword
// Companion objects replace the need for "static" members on Classes

fun getFacebookName(id: Int): String {
    return id.toString()
}

class ObjectWithCompanion {
    companion object {
        fun bar() {
            println("Companion object called!")
        }
    }
}

class TypicalUser {
    val nickname: String

    constructor(email: String) {
        nickname = email.substringBefore("@")
    }

    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }
}

// implementation of the factory pattern with companion object

class CompanionUser private constructor(val nickname: String) {
    companion object {
        fun newEmailUser(email: String) = CompanionUser(email.substringBefore('@'))
        fun newFBUser(fbId: Int) = CompanionUser(getFacebookName(fbId))
    }
}

// named companion object

class CompanionPerson(val name: String) {
    companion object Loader {
        fun fromJSON(jsonText: String): CompanionPerson {
            return CompanionPerson("Jimmy")
        }
    }
}

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class FactoryPerson(val name: String) {
    companion object : JSONFactory<FactoryPerson> {
        override fun fromJSON(jsonText: String): FactoryPerson {
            return FactoryPerson("Elom")
        }
    }
}

fun <T>loadFromJSON(factory: JSONFactory<T>): T {
    return factory.fromJSON("test")
}

class SeparateCompanionPerson(val name: String) {
    companion object
}



fun main(args: Array<String>) {
    ObjectWithCompanion.bar()

    val typicalEmailUser = TypicalUser("test@gmail.com")
    val typicalFBUser = TypicalUser(122333)

    println(typicalEmailUser.nickname)
    println(typicalFBUser.nickname)

    val emailUser = CompanionUser.newEmailUser("mcgoo@mail.com")
    val fbUser = CompanionUser.newFBUser(333221)

    println(emailUser.nickname)
    println(fbUser.nickname)

    // named companion objects can be called directly on their parent class
    // they can also be called via their name on the parent class (Parent.Name.function())
    // if no name is provided, the default is "Companion" (Parent.Companion.function())

    val jsonPerson = CompanionPerson.fromJSON("{name: Jimmy}")
    val loaderPerson = CompanionPerson.Loader.fromJSON("{name: Jimmy}")

    println(jsonPerson.name)
    println(loaderPerson.name)

    loadFromJSON(FactoryPerson)

    // companion objects can receive extension functions

    fun SeparateCompanionPerson.Companion.fromJSON(someJSON: String): SeparateCompanionPerson {
        return SeparateCompanionPerson("Wendy")
    }

    // once create the can be called just like any other companion object member

    println(SeparateCompanionPerson.fromJSON("{name: Wendy}").name)
}