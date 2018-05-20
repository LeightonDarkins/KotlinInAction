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

    println(getMnemonic(Color.RED))
    println(getWarmth(Color.BLUE))

    println(mix(Color.BLUE, Color.VIOLET))
    println(mixOptimised(Color.BLUE, Color.VIOLET))

    // throw exceptions
    // mix(Color.RED, Color.BLUE)
    // mixOptimised(Color.BLUE, Color.RED)
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "RICHARD"
        Color.ORANGE -> "OF"
        Color.YELLOW -> "YORK"
        Color.GREEN -> "GAVE"
        Color.BLUE -> "BATTLE"
        Color.INDIGO -> "IN"
        Color.VIOLET -> "VAIN"
    }

fun getWarmth(color: Color) =
    when (color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "WARM"
        Color.GREEN -> "NEUTRAL"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "COLD"
    }

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("dirty colour!")
    }

// is when doesn't receive arguments, the branch expression can be any boolean
fun mixOptimised(c1: Color, c2: Color) =
    when {
        (c1 == Color.RED && c2 == Color.YELLOW ||
        c1 == Color.YELLOW && c2 == Color.RED) ->
            Color.ORANGE

        (c1 == Color.BLUE && c2 == Color.YELLOW ||
        c1 == Color.YELLOW && c2 == Color.BLUE) ->
            Color.GREEN

        (c1 == Color.BLUE && c2 == Color.VIOLET ||
        c1 == Color.VIOLET && c2 == Color.BLUE) ->
            Color.INDIGO

        else -> throw Exception("dirty colour!")
    }