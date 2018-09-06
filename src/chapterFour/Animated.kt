package chapterFour

// you cannot create an instance of this class
// it must be extended
abstract class Animated {
    // abstract functions must be overridden in subclasses
    abstract fun animate()

    // this function is open to be overridden in a subclass
    open fun stopAnimating() {}

    // this function is not open to be overridden in a subclass
    fun animateTwice() {}
}