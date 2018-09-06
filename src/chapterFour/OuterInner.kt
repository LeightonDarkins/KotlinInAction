package chapterFour

// reference of how to access a parent or "outer class" from an "inner" class

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}