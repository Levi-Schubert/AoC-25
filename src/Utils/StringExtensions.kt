package Utils

fun String.splitAtIndex(index: Int): Pair<String, String> {
    val first = this.substring(0, index)
    val second = this.substring(index)
    return Pair(first, second)
}

fun String.splitHalf(): Pair<String, String>{
    val half = this.length/2
    return Pair(this.substring(0, half), this.substring(half))
}

/**
 * expects there to only be two items to split
 */
fun String.splitToInt(delimiter: Char): Pair<Int, Int> {
    val parts = this.split(delimiter)
    return Pair(parts[0].toInt(), parts[1].toInt())
}

/**
 * expects there to only be two items to split
 */
fun String.splitToLong(delimiter: Char): Pair<Long, Long> {
    val parts = this.split(delimiter)
    return Pair(parts[0].toLong(), parts[1].toLong())
}

fun String.splitAtIndexSecondInt(index: Int): Pair<String, Int>{
    val first = this.substring(0, index)
    val second = this.substring(index).toInt()
    return Pair(first, second)
}

fun String.splitAtIndexInts(index: Int): Pair<Int, Int>{
    val first = this.substring(0, index).toInt()
    val second = this.substring(index).toInt()
    return Pair(first, second)
}