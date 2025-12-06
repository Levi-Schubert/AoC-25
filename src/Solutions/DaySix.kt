package Solutions

class DaySix : Solver {
    override fun partOne(lines: List<String>): String {
        val problems = getProblems(lines)

        val answer = getAnswerFromProblems(problems)

        return answer.toString()
    }

    override fun partTwo(lines: List<String>): String {
        val problems = getProblems(lines, true)

        val answer = getAnswerFromProblems(problems)

        return answer.toString()
    }

    private fun getAnswerFromProblems(problems: List<Problem>): Long {
        var total = 0L
        problems.forEach { problem ->
            total += problem.getAnswer()
        }
        return total
    }

    private fun getProblems(lines: List<String>, partTwo: Boolean = false): List<Problem> {
        val temp = mutableListOf<List<String>>()
        val problems = mutableListOf<Problem>()

        if(partTwo){
            var start = 0
            for(i in 0..<lines[0].length){
                if(lines[0][i] == ' ' || lines[0].length-1 == i){
                    var allEmpty = true
                    for(j in 1..<lines.size-1){
                        if(lines[j][i] != ' ' && i != lines[j].length-1){
                            allEmpty = false
                        }
                    }
                    if(allEmpty || i == lines[0].length-1){
                        val longs = mutableListOf<Long>()
                        var tempString = ""
                        for(c in start..i){
                            for(y in 0..<lines.size-1){
                                tempString += lines[y][c]
                            }
                            if(tempString.trim().length != 0){
                                longs.add(tempString.trim().toLong())
                            }
                            tempString = ""
                        }
                        val end = if(i <= lines[lines.size-1].length){ i }else{ lines[lines.size -1].length }
                        val sign = lines[lines.size-1].substring(start, end).find{ch -> ch != ' '}
                        problems.add(Problem(longs, sign.toString()))
                        start = i +1
                    }
                }
            }

        }else {
            for (i in 0..<lines.size) {
                temp.add(lines[i].trim(' ').split("\\s+".toRegex()))
            }

            for (i in 0..<temp[0].size) {
                val nums = mutableListOf<Long>()
                for (j in 0..<temp.size - 1) {
                    nums.add(temp[j][i].toLong())
                }
                problems.add(Problem(nums, temp[temp.size - 1][i]))
            }
        }

        return problems
    }

    class Problem(nums: List<Long>, sign: String) {
        var numbers = emptyList<Long>()
        var multiply = false
        var s = ""

        init {
            numbers = nums


            if(sign == "*"){
                multiply = true
            }
        }


        fun getAnswer(): Long {
            var answer = 0L

            for(i in 1..<numbers.size){
                answer = if(multiply){
                    if(i == 1){
                        numbers[0] * numbers[i]
                    }else{
                        answer * numbers[i]
                    }
                }else{
                    if(i == 1){
                        numbers[0] + numbers[i]
                    }else{
                        answer + numbers[i]
                    }
                }
            }

            return answer
        }
    }


}