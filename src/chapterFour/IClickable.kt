package chapterFour

interface IClickable {
    fun click()
    // default behaviour defined in interface
    fun showOff() = println("IClickable .showOff")
}