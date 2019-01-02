package chapterFive

data class CollectionPerson(val name: String, val age: Int)

fun main(args: Array<String>) {
    println("=== Collections ===")

    println("--> FILTER <--")
    println("The FILTER function goes through a list and returns the elements for which the given lambda returns true")

    val list = listOf(1,2,3,4,5)
    val evens = list.filter { it % 2 ==0 }
    val odds = list.filter { it % 2 != 0 }

    println("Even Numbers: $evens")
    println("Odd Numbers: $odds")

    val people = listOf(CollectionPerson("Alice", 27), CollectionPerson("Bob", 31))
    val olderThan30 = people.filter { it.age > 30 }

    println("People older than 30: $olderThan30")

    println("--> MAP <--")
    println("FILTER can remove unwanted elements from a collection, but it cannot change the elements themselves")
    println("that's where MAP comes in")

    val squares = list.map { it * it }
    println("list of squares: $squares")

    println("MAP returns a new collection containing all of the original items, after the given lambda is applied")

    val names = people.map { it.name }
    println("just the names: $names")
    println(people.map(CollectionPerson::name))

    println("--> FILTER + MAP <--")
    println("calls can be chained together...")

    val namesOfPeopleOver30 = people.filter { it.age > 30 }.map { it.name }
    println("These people are over 30: $namesOfPeopleOver30")

    val maxAge = people.maxBy { it.age }?.age
    val oldestPerson = people.filter { it.age == maxAge }
    val oldestPersonsName = oldestPerson.map(CollectionPerson::name)
    println("The oldest person is: $oldestPersonsName")

    println("You can apply FILTER and MAP to maps as well")
    println("using .mapValues, .mapKeys, .filterValues and .filterKeys")
    val map = mapOf(0 to "zero", 1 to "one")
    val upperCaseValues = map.mapValues { it.value.toUpperCase() }
    println("Values in uppercase: $upperCaseValues")

    println("--> ALL, ANY, COUNT, FIND - Applying predicates to collections <--")

    val canBeInClub27 = { p: CollectionPerson -> p.age <= 27 }
    println("Is everyone in the 27 club? ${people.all(canBeInClub27)}")
    println("Is anyone in the 27 club? ${people.any(canBeInClub27)}")

    println(".any and .all can be negated with '1' but it's not advised")
    val numbers = listOf(1,2,3)
    val notAllNumbersEqualThree = !numbers.all { it == 3 }
    val anyNumbersAreNotEqualToThree = numbers.any { it != 3 }
    println("Not all threes? $notAllNumbersEqualThree")
    println("Any non-threes? $anyNumbersAreNotEqualToThree")

    println("count the number of items in a collection that match the predicate")
    println(people.count(canBeInClub27))

    println("find the items in a collection that match the predicate")
    println(people.find(canBeInClub27))

    println("groupBy a predicate")
    println("results in a map from the given key (in this case, age) to the groups of items")
    val morePeople = listOf(CollectionPerson("Jimmy", 21), CollectionPerson("Mary", 22), CollectionPerson("Sheila", 21))
    val groupedPeople = morePeople.groupBy { it.age }
    println(groupedPeople)

    val letterList = listOf("a", "ab", "b")
    val letterGroups = letterList.groupBy(String::first)
    println(letterGroups)

    println("FlatMap and Flatten - Processing Nested Collections")

    class CollectionBook(val title: String, val authors: List<String>)

    val strings = listOf("abc", "def")
    val stringsFlatMappedToList = strings.flatMap { it.toList() }
    println("flat mapped strings: $stringsFlatMappedToList")

    val books = listOf(CollectionBook("Thursday Next", listOf("Jasper Fforde")),
            CollectionBook("Mort", listOf("Terry Pratchett")),
            CollectionBook("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")))


    val bookAuthors = books.flatMap { it.authors }
    // to set removes duplicates from a collection
    val setOfBookAuthors = bookAuthors.toSet()

    println(setOfBookAuthors)

    println("--> SEQUENCES <---")

    val startsWithJ = morePeople.map(CollectionPerson::name).filter { it.startsWith("J") }
    println("Without sequences: $startsWithJ")

    // converting a list to a sequence prevents creating multiple intermediate lists as the chained operations are completed
    // do this when working with large lists for maximum efficiency
    val sequenceStartsWithJ = morePeople.asSequence()
            .map(CollectionPerson::name)
            .filter { it.startsWith("J") }
            .toList()

    println("With sequence: $sequenceStartsWithJ")

    // sequences complete the full chain of events on each item
    // lists do each step, create a new list, and move to the next step
    // using sequences prevents useless iterations when a result is already found
    // sequences use lazy evaluation
    // lists use eager evaluation

    val someNumbers = listOf(1,2,3,4)
    val squareGreaterThan4 = someNumbers.map {
        println("squaring...")

        it * it
    }.find {
        println("finding...")

        it > 3
    }

    println("the square that's greater than 4: $squareGreaterThan4")

    val sequenceSquareGreaterThan4 = someNumbers.asSequence()
            .map {
                println("squaring...")

                it * it
            }.find {
                println("finding...")

                it > 3
            }

    println("the square that's greater than 4 (using sequence): $sequenceSquareGreaterThan4")


}