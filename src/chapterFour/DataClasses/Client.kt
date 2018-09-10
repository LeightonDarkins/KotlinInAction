package chapterFour.DataClasses

class Client (val name: String, val postalCode: Int) {
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"

    override fun equals(other: Any?): Boolean {
        // "is" is equivalent to instanceof in Java
        if (other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode

    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Client(name, postalCode)
}

data class DataClient(val name: String, val postalCode: Int)

fun main(args: Array<String>) {
    val client2 = Client("Jimmy", 75033)
    val client1 = Client("Jimmy", 75033)

    println(client1.toString())
    println("Equal? ${client1 == client2}")
    println("Equal? ${client1.equals(client2)}")

    // when the equals method is overridden, hashCode must be overridden with it
    // otherwise methods like "contains" will not return true when given objects that meet the criteria of "equals"

    val processed = hashSetOf(Client("Alice", 654321))

    println("Hash Set Contains Alice? ${processed.contains(Client("Alice", 654321))}")

    val client3 = Client("Timmy", 123456)
    println("Client3: $client3")
    println("Client3 Copied, With New Postal Code: ${client3.copy(postalCode = 654321)}")

    // using the data modifier provides all of the functionality above "for free"

    val dataClient1 = Client("Billy", 123456)
    val dataClient2 = Client("Billy", 123456)

    println(dataClient1.toString())
    println("Equal? ${dataClient1 == dataClient2}")
    println("Equal? ${dataClient1.equals(dataClient2)}")

    val dataProcessed = hashSetOf(DataClient("Alice", 654321))

    println("Hash Set Contains Alice? ${dataProcessed.contains(DataClient("Alice", 654321))}")

    val dataClient3 = DataClient("Timmy", 123456)
    println("DataClient3: $dataClient3")
    println("DataClient3 Copied, With New Postal Code: ${dataClient3.copy(postalCode = 654321)}")
}
