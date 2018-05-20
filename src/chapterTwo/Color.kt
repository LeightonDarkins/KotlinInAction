package chapterTwo

// Define an enum type, with values
enum class Color (val r: Int, val g: Int, val b: Int) {

    // list of values for this enum type
    RED(255,0,0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0,255,0),
    BLUE(0,0,255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);
    // the semi-colon up there ^^^^ separates the value list from the function declarations

    // functions available on the enum values
    fun rgb() = "rgb($r, $g, $b)"
}

fun main(args: Array<String>) {
    println(Color.RED.rgb())
}