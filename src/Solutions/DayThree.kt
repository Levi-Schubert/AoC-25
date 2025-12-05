package Solutions

import Utils.toListOfInt

class DayThree : Solver {

    override fun partOne(lines: List<String>): String {
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

    override fun partTwo(lines: List<String>): String {
        var voltage: Long = 0

        lines.forEach { battery ->
            voltage += Battery(battery).getVoltage()
        }

        return voltage.toString()
    }
}


class Battery(input: String) {
    var cells = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0)
    val cellList = input.toListOfInt()
    val debug = input

    init {
        for(cellIndex in 0..<cellList.size){ // 818181911112111
            val leftMostIndex =  12 - (cellList.size - cellIndex)
            val start = if(leftMostIndex >= 0){
                leftMostIndex
            }else{
                0
            }
            for(index in start..<cells.size){
                if(12-index > cellList.size-(cellIndex)){
                    break
                }
                if(cellList[cellIndex] > cells[index]){
                    cells[index] = cellList[cellIndex]
                    resetCellsPastIndex(index)
                    break
                }
            }

        }
    }

    fun getVoltage(): Long {
        return cells.joinToString("").toLong()
    }

    fun resetCellsPastIndex(index: Int){
        for(i in index+1..11){
            cells[i] = 0
        }
    }

}

