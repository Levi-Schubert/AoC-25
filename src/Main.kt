import Solutions.*
import Utils.*

/**
 *
 */
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

    var answer: String? = null
    when(selectedChallenge.first){
        1 -> {
            val solver = DayOne()
            answer = if(selectedChallenge.second == 1){
                solver.partOne(fileResult.first)
            }else{
                solver.partTwo(fileResult.first)
            }
        }
        2 -> {
            val solver = DayTwo()
            answer = if(selectedChallenge.second == 1){
                solver.partOne(fileResult.first)
            }else{
                solver.partTwo(fileResult.first)
            }
        }
        else -> {
            println("Invalid or unsolved challenge.")
        }
    }
    println("Answer: $answer")
}