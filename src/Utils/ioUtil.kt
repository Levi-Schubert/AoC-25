package Utils

import java.util.Scanner


fun PromptDayPart(): Triple<Int, Int, String>{
    val scanner = Scanner(System.`in`)
    println("Select AoC-2025 day: ")
    val day = scanner.nextInt()
    println("Select part: ")
    val part = scanner.nextInt()
    println("FilePath to input: ")
    val filepath = scanner.nextLine()
    return Triple(day, part, filepath)
}
