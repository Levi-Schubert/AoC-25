package Solutions

class DayFive: Solver {
    override fun partOne(lines: List<String>): String {
        val items = getRangesAndIngredients(lines)
        var freshCount = 0
        items.second.forEach { ingredient ->
            val match = items.first.firstOrNull { range -> range.first <= ingredient && ingredient <= range.second }
            if(match != null) { freshCount += 1 }
        }

        return freshCount.toString()
    }

    override fun partTwo(lines: List<String>): String {
        val ranges = getRangesAndIngredients(lines).first.sortedBy { it.first }
        val mergedRanges = mergeRanges(ranges)

        var totalSize: Long = 0
        for (range in mergedRanges) {
            totalSize += range.second - range.first + 1
        }

        return totalSize.toString()
    }


    private fun getRangesAndIngredients(lines: List<String>): Pair<List<Pair<Long, Long>>, List<Long>>{
        val ranges = mutableListOf<Pair<Long, Long>>()
        val ingredients = mutableListOf<Long>()
        var parsingRange = true
        for(i in 0..<lines.size){
            if(lines[i].isEmpty()){
                parsingRange = false
                continue
            }
            if(parsingRange){
                val items = lines[i].split('-')
                ranges.add(Pair(items[0].toLong(), items[1].toLong()))
            }else{
                ingredients.add(lines[i].toLong())
            }
        }
        return Pair(ranges, ingredients)
    }

    private fun mergeRanges(ranges: List<Pair<Long, Long>>): List<Pair<Long, Long>> {
        val mergedRanges = mutableListOf<Pair<Long, Long>>()
        var currentRange = ranges.first()

        for (i in 1..<ranges.size) {
            val nextRange = ranges[i]
            // Merge overlapping or adjacent ranges
            if (nextRange.first <= currentRange.second + 1) {
                currentRange = Pair(currentRange.first, maxOf(currentRange.second, nextRange.second))
            } else {
                mergedRanges.add(currentRange)
                currentRange = nextRange
            }
        }
        mergedRanges.add(currentRange)
        return mergedRanges
    }

}