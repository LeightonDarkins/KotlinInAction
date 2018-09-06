package chapterThree

fun main (args:Array<String>) {
    println("12.345-6.A".split('.', '-'))
    println("12.345-6.A".split(".".toRegex()))

    val filePath = "Users/ldarkins/book/chapter.adoc"

    println(parsePathKotlin(filePath))
    println(parsePathRegex(filePath))
}

fun parsePathKotlin(path: String): String {
    val filePath = "Users/ldarkins/book/chapter.adoc"

    val directory = filePath.substringBeforeLast('/')
    val fullFileName = filePath.substringAfterLast('/')

    val fileName = fullFileName.substringBeforeLast(('.'))
    val extension = fullFileName.substringAfterLast(('.'))

    return "dir: $directory, file name: $fileName, extension: $extension"
}

fun parsePathRegex(path: String): String {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)

    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        return "dir: $directory, file name: $filename, extension: $extension"
    }

    return ""
}