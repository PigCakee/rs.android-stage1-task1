package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
        val resultArray = ArrayList<Int>()
        input.sort()
        val minNum = input.first()
        val maxNum = input.last()
        var maxSum = 0
        var minSum = 0
        for (i in input) {
            if (i == minNum) continue
            else maxSum += i
        }
        for (i in input) {
            if (i == maxNum) continue
            else minSum += i
        }
        resultArray.add(minSum)
        resultArray.add(maxSum)

        return resultArray.toIntArray()
    }
}
