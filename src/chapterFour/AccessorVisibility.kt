package chapterFour

// You can change accessor visibility in Kotlin
class LengthCounter {
    var count: Int = 0
        // here the setter for "count" is private, therefore cannot be called from outside of this class
        // attempting to call LengthCounter.count will cause a compilation error
        private set

    fun addWord(word: String) {
        count += word.length
    }
}

fun main(args: Array<String>) {
    var counter = LengthCounter()

    println(counter.count)
    counter.addWord("test")
    counter.addWord("banana")
    counter.addWord("cheese")
    println(counter.count)
}