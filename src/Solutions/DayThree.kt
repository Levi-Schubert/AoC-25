package Solutions

import Utils.splitHalf
import Utils.splitToLong
import Utils.toListOfInt

class DayThree {

    fun partOne(lines: List<String>): String {
        var voltage = 0

        lines.forEach {
            val cells = it.toListOfInt()
            var first = cells.first()
            var second = 0
            for(i in 1..<cells.size){
                if(cells[i] > first && i != cells.size-1){
                    first = cells[i]
                    second = cells[i+1]
                }else{
                    if(cells[i] > second){
                        second = cells[i]
                    }
                }
            }
            voltage += "$first$second".toInt()
        }


        return voltage.toString()
    }

    fun partTwo(lines: List<String>): String {

        return ""
    }
}

