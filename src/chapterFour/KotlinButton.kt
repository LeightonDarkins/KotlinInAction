package chapterFour

class KotlinButton : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {}

    // equivalent to "static class ButtonState" in Java
    // does not hold a reference to the parent class "KotlinButton"
    class ButtonState : State
}