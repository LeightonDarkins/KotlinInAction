package chapterFour;

import org.jetbrains.annotations.NotNull;

public class JavaButton implements View {
    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(@NotNull State state) {}

    // equivalent to "inner class ButtonState" in Kotlin
    // holds a reference to the parent class (JavaButton)
    public class ButtonState implements State {}
}
