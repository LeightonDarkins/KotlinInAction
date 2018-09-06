/*
package chapterFour


// intentionally broken example of visibility modifiers

internal open class TalkativeButton : IFocusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk...")
}

// cannot expose a more visible (public) method on an "internal" class
// fix by making the class public, or making the method internal

// extension functions DO NOT get access to private or protected members of their class
fun TalkativeButton.giveSpeech() {
    // yell() is private, only visible inside the class
    yell()

    // whisper() is protected, only visible in a subclass
    whisper()
}

 */