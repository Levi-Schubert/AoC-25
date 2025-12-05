package Solutions

import Utils.splitHalf
import Utils.splitToLong

class DayTwo : Solver {
    override fun partOne(lines: List<String>): String {
        val invalid = emptyList<Long>().toMutableList()
        val ranges = lines.first().split(',')
        ranges.forEach { range ->
            val items = range.splitToLong('-')
            for(i in items.first until items.second +1 step 1){
                if(i.toString().length % 2 == 0){
                    val check = i.toString().splitHalf()
                    if(check.first == check.second){
                        invalid.add(i)
                    }
                }
            }
        }
        return invalid.sum().toString()
    }

    override fun partTwo(lines: List<String>): String {
        val invalid = emptyList<Long>().toMutableList()
        val ranges = lines.first().split(',')
        ranges.forEach { range ->
            val items = range.splitToLong('-')
            for(i in items.first until items.second +1 step 1){
                if(!isValid(i.toString())){
                    invalid.add(i)
                }
            }
        }
        return invalid.sum().toString()
    }

    private fun isValid(id: String): Boolean{
        val half = id.length/2
        for (i in 1..half){
            val sub = id.take(i)
            val occurrences = id.split(sub)
            if(occurrences.all{it.isEmpty()}){
                return false
            }
        }
        return true
    }
}