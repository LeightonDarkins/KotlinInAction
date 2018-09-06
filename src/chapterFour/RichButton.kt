package chapterFour

// this class is open for subclassing (extension)
// "O" in SOLID
// classes are closed (final) by default in Kotlin
open class RichButton : IClickable {
    // this function cannot be overridden in a subclass
    fun disable() {}

    // this function can be overridden in a subclass
    open fun animate() {}

    // this function overrides an open function (from the interface), and is open itself
    override fun click() {}

    // this function overrides an open function (from the interface, and is final (cannot be overridden in a subclass)
    final override fun showOff() {}
}