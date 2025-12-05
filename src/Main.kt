import Solutions.*
import Utils.*
import kotlin.system.exitProcess

fun main() {
    val relativeFileRoot = "inputs/"



    println("AoC 2025 - Levi Schubert")
    val fileUtil = FileUtil()
    val io = ioUtil()

    val selectedChallenge = io.PromptDayPart()
    val fileResult = fileUtil.GetFileLines(relativeFileRoot, selectedChallenge.third)

    if(!fileResult.second || fileResult.third){
        if(!fileResult.second) {
            println("Unable to read file. Verify file path. \nExiting...")
        }else{
            println("No text found in file. Verify file content. \nExiting...")
        }
        return
    }


    val solver = getSolver(selectedChallenge.first)
    if(solver == null){
        println("Invalid or unsolved challenge.")
        exitProcess(0)
    }
    val answer = if(selectedChallenge.second == 1){
        solver.partOne(fileResult.first)
    }else{
        solver.partTwo(fileResult.first)
    }
    println("Answer: $answer")
    exitProcess(1)
}


fun getSolver(day: Int): Solver? {
    return when(day){
        1 -> { DayOne() }
        2 -> { DayTwo() }
        3 -> { DayThree() }
        4 -> { DayFour() }
        else -> { null }
    }
}