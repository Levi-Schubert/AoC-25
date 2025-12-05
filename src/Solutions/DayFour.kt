package Solutions


class DayFour : Solver{
    override fun partOne(lines: List<String>): String {
        val map = Map(lines)

        return map.accessible.count().toString()
    }

    override fun partTwo(lines: List<String>): String {
        val map = Map(lines)

        return map.removeAllPossibleRolls().toString()
    }
}

class Map(input: List<String>){
    val grid = mutableListOf<MutableList<Char>>()
    var accessible = mutableListOf<Pair<Int, Int>>()

    init{
        fillGrid(input)
        calcAccessibleCoordinates()
    }

    fun removeAllPossibleRolls(): Int{
        var removed = 0
        while(accessible.isNotEmpty()){
            accessible.forEach { roll ->
                grid[roll.second][roll.first] = '.'
                removed += 1
            }
            accessible = mutableListOf()
            calcAccessibleCoordinates()
        }
        return removed
    }

    private fun fillGrid(input: List<String>){
        input.forEach { line ->
            val gridRow = mutableListOf<Char>()
            line.forEach { ch ->
                gridRow.add(ch)
            }
            grid.add(gridRow)
        }
    }

    private fun calcAccessibleCoordinates(){
        for(i in 0..<grid.size){
            for(j in 0..<grid[i].size){
                if(!hasRoll(getCoordValue(j, i))){ continue }

                var occupiedNeighbors = 0
                getNeighborCoordinates(j,i).forEach { coordinate ->
                    if( occupiedNeighbors < 4 && hasRoll(getCoordValue(coordinate.first, coordinate.second))){
                        occupiedNeighbors += 1
                    }
                }

                if(occupiedNeighbors < 4){
                    accessible.add(Pair(j,i))
                }
            }
        }
    }

    private fun getNeighborCoordinates(x: Int, y: Int):List<Pair<Int,Int>>{
        val coordinates = mutableListOf<Pair<Int,Int>>()

        val lowerX = if(x > 0){ x-1 }else{ x }
        val lowerY = if(y > 0){ y-1 }else{ y }
        val upperX = if(x < grid[y].size -1){ x+1 }else{ x }
        val upperY = if(y < grid.size - 1){ y+1 }else{ y }

        for(neighborX in lowerX..upperX){
            for(neighborY in lowerY..upperY){
                if(!(neighborX == x && neighborY == y)){
                    coordinates.add(Pair(neighborX, neighborY))
                }
            }
        }

        return coordinates
    }

    fun getCoordValue(x: Int, y: Int): Char{
        return grid[y][x]
    }

    private fun hasRoll(c: Char): Boolean{
        return c == '@'
    }

    fun printMap(){
        println("----MAP----")
        for(i in 0..<grid.size){
            for(j in 0..<grid[i].size){
                print(grid[i][j])
            }
            print("\n")
        }
        println("----MAP----")
    }

    fun printAccessibleMap(){
        println("-ACCESSIBLE-")
        for(i in 0..<grid.size){
            for(j in 0..<grid[i].size){
                if(accessible.contains(Pair(j,i))){
                    print("█")
                }else {
                    print(grid[i][j])
                }
            }
            print("\n")
        }
        println("-ACCESSIBLE-")
    }

}