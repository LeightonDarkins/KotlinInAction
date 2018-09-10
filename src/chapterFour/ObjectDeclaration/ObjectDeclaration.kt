package chapterFour.ObjectDeclaration

import chapterTwo.Person
import java.io.File

// this declares a Singleton Payroll class
// "object"s cannot contain constructors
object PayRoll {
    var allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {
            println(person.name)
        }
    }
}

// Singleton Comparator
// these typically don't need any state, they're just implementing a certain comparison algorithm, then returning 0 or 1
// creating a Singleton for this makes sense
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

data class DataPerson(val name: String) {
    // this does not create a new comparator for every DataPerson
    // this NameComparator is shared between all DataPerson instances
    object NameComparator : Comparator<DataPerson> {
        override fun compare(o1: DataPerson, o2: DataPerson): Int = o1.name.compareTo(o2.name)
    }
}

fun main(args: Array<String>) {
    // no () because there are no constructors for this Singleton
    val payroll = PayRoll
    val caseInsensitiveFileComparator = CaseInsensitiveFileComparator

    // properties and methods can be accessed as normal

    payroll.allEmployees.add(Person("Jen",false))
    payroll.allEmployees.add(Person("Jen",false))

    payroll.calculateSalary()

    println("Same File? ${caseInsensitiveFileComparator.compare(File("/user"), File("/user"))}")

    // sorting with our singleton comparator
    val fileList = listOf(File("/Z"), File("/a"))
    println(fileList.sortedWith(CaseInsensitiveFileComparator))

    val personList = listOf(DataPerson("Sarah"), DataPerson("Betty"))
    println(personList.sortedWith(DataPerson.NameComparator))
}