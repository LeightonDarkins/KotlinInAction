package chapterThree

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }
}

fun saveUserDRY(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
}

fun saveUserDRYer(user: User) {
    // the arg "user" is accessible inside the local method, no need to pass it to validate()

    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
}

fun User.validateBeforeSave() {
    // user is now the context for the method, no need to pass a "user" arg, or reference it like "user.id" or "user.name"

    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUserDRYest(user: User) {
    user.validateBeforeSave()
}

fun main(args: Array<String>) {
    saveUser(User(1, "test", "test"))
    saveUserDRY(User(2, "test", "test"))
    saveUserDRYer(User(3, "test", "test"))
    saveUserDRYest(User(4, "test", "address"))
}