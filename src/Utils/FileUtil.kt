package Utils

import java.io.File

class FileUtil {
    fun GetFileLines(root: String, path: String): Triple<List<String>, Boolean, Boolean> {
        val file = File(root + path)
        var lines = emptyList<String>()
        var success = true
        try {
            lines = file.readLines()
        }catch (ex: Exception){
            success = false
            println("FileUtil: error reading file at path: $path. \nException: ${ex.localizedMessage}")
        }
        val empty = lines.isEmpty()
        return Triple(lines, success,empty)
    }
}