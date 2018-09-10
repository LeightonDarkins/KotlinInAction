package chapterFour

// Kotlin interfaces can contain abstract property definitions
interface IUser {
    // here "nickname" has no value, but any class that implements this interface needs to provide a way to obtain this value
    val nickname: String
}

// concise override syntax, sets "nickname" to the provided string
class PrivateUser(override val nickname: String) : IUser

// custom getter overriding the nickname property
// this calculates the nickname every time SubscribingUser.nickname is called
class SubscribingUser(val email: String) : IUser {
    override val nickname: String
        get() = email.substringBefore('@')
}

// assign the nickname value in the object initializer
// calls out to FB to get the users' nickname once, at the time of initialization
// this calculates the nickname once, and stores it for the life of the object
class FacebookUser(accountId: Int) : IUser {
    override val nickname = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        return accountId.toString()
    }

}

// Kotlin interfaces can also contain properties with getters and setters
// they just don't reference a backing field
interface ICoolUser {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class CoolUser(override val email: String) : ICoolUser

// you can access a backing field in a setter using the special keyword "field"
// in a setter you can read and write to/from the field value
// in a getter you can only read it
// this example triggers a log every time the address field is changed
// there's no need to implement a custom getter unless you're adding additional functionality
// the getter in this example would look like this: "get() = field"
class BackingUser(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""Address was changed for $name: "$field" -> "$value".""".trimIndent())
            field = value
        }
}

// all of these properties are accessible via OBJ.nickname
fun main(args: Array<String>) {
    println(PrivateUser("Jimmy").nickname)
    println(SubscribingUser("Bobby@gmail.com").nickname)
    println(FacebookUser(12345).nickname)
    println(CoolUser("Billy@test.com").nickname)

    val backingUser = BackingUser("Alice")
    println("Default Address: $backingUser.address")
    backingUser.address = "test address"
    println("New Address: $backingUser.address")
}