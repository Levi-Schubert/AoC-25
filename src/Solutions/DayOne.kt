package Solutions

import Utils.splitAtIndexSecondInt
import Utils.splitAtIndexInts

class DayOne {
    fun partOne(lines: List<String>): String {
        val dial = Dial()

        performDialTurns(lines, dial)

        return "${dial.zeroCount}"
    }

    fun partTwo(lines: List<String>): String {
        val dial = Dial()

        performDialTurns(lines, dial)

        return "${dial.zeroPasses}"
    }

    private fun performDialTurns(lines: List<String>, dial: Dial){
        lines.forEach { rotation ->
            val items = rotation.splitAtIndexSecondInt(1)

            if(items.first == "L"){
                dial.turnLeft(items.second)
            }else{
                dial.turnRight(items.second)
            }
        }
    }
}


private class Dial{
    var dialIndex = 50
    var prevIndex = 50

    var zeroCount = 0
    var zeroPasses = 0

    fun turnLeft(clicks: Int){
        val clicksToPerform = minimizeClicks(clicks)

        val tempDial = dialIndex - clicksToPerform
        dialIndex = if(tempDial < 0){
            100 + tempDial
        }else{
            tempDial
        }

        performFinalCounts(true)
        prevIndex = dialIndex
    }

    fun turnRight(clicks: Int){
        val clicksToPerform = minimizeClicks(clicks)
        val tempDial = dialIndex + clicksToPerform

        dialIndex = if(tempDial > 99){
            tempDial - 100
        }else{
            tempDial
        }

        performFinalCounts(false)
        prevIndex = dialIndex
    }

    fun minimizeClicks(clicks: Int): Int{
        val clickString = clicks.toString()
        return if(clickString.length > 2){
            val split = clickString.splitAtIndexInts(clickString.length - 2)
            zeroPasses += split.first
            split.second
        }else{
            clicks
        }
    }

    fun performFinalCounts(left: Boolean){
        if(dialIndex == 0){
            zeroCount += 1
            zeroPasses += 1
        } else {
            if (left) {
                if (prevIndex < dialIndex && prevIndex != 0) { zeroPasses += 1 }
            } else {
                if (prevIndex > dialIndex) { zeroPasses += 1 }
            }
        }
    }

}