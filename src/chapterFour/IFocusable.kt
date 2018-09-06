package chapterFour

interface IFocusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("IFocusable .showOff")
}