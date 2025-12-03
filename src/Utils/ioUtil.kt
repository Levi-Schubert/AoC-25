package Utils


class ioUtil {
    fun PromptDayPart(): Triple<Int, Int, String>{
        print("Select AoC-2025 day: ")
        val day = readln().toInt()
        print("Select part: ")
        val part = readln().toInt()
        print("FilePath to input: ")
        val filepath = readln()
        println("Selected Day $day, Part $part, File: $filepath")
        return Triple(day, part, filepath)
    }
}