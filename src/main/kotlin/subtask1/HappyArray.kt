package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        val happyList = ArrayList<Int>()
        var tempSadArray = sadArray
        for (i in tempSadArray.indices){
            happyList.add(tempSadArray.first())
            for (index in 1 until tempSadArray.size) {
                if (index == tempSadArray.size - 1) break
                if (tempSadArray[index] > tempSadArray[index-1] + tempSadArray[index+1]) {
                    continue
                } else {
                    happyList.add(tempSadArray[index])
                }
            }
            happyList.add(tempSadArray.last())
            tempSadArray = happyList.toIntArray()
            happyList.clear()
        }
        return tempSadArray
    }
}
