package chapterFour.ObjectExpressions

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

fun addListener () {
    var clickCount = 0
    var enterCount = 0

    // Anonymous objects can be created anywhere in Kotlin
    // this one extends MouseAdapter for use as an EventListener
    // this object has access to all of the members of the function within which it was created.
    val listener = object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            clickCount++
            super.mouseClicked(e)
        }

        override fun mouseEntered(e: MouseEvent?) {
            enterCount++
            super.mouseEntered(e)
        }
    }
}

