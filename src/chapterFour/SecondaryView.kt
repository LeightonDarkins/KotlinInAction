package chapterFour

import javax.naming.Context
import javax.swing.text.AttributeSet

// no default constructor for SecondaryView (that would need "open class SecondaryView()"
// define two constructors for SecondaryView
open class SecondaryView {
    constructor(ctx: Context) {
        // some constructor code goes here
    }

    constructor(ctx: Context, attr: AttributeSet) {
        // some constructor code goes here
    }
}

// to extend SecondaryView
class SecondaryButton : SecondaryView {
    // delegate this constructor to it's parent
    // replace "super" with "this" (and the correct args) to delegate to another constructor within this class
    constructor(ctx: Context) : super(ctx) {
        // some constructor code
    }

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {
        // some constructor code
    }
}