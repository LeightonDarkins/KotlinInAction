package chapterFour

// ":" means "implements" AND "extends"
class NewButton : IClickable, IFocusable {
    // override is mandatory in Kotlin
    override fun click() = println("I was clicked!")

    // showOff has a default implementation, so doesn't need to be overridden
    // if showOff is defined more than once in interfaces implemented by this class, it must be overridden
    override fun showOff() {
        // call the interface definitions of .showOff()
        super<IClickable>.showOff()
        super<IFocusable>.showOff()
    }
}