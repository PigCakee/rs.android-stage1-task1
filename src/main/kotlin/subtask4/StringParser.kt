package subtask4

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val resultArrayList = arrayListOf<String>()
        for (indexedValue in inputString.withIndex()) {
            if (indexedValue.value == '[' || indexedValue.value == '<' || indexedValue.value == '(') {
                val closeChar: Char = when (indexedValue.value) {
                    '(' -> ')'
                    '[' -> ']'
                    '<' -> '>'
                    else -> ' '
                }
                var bracketLevel = 0
                for (index in indexedValue.index + 1 until inputString.length) {
                    if (inputString[index] == indexedValue.value) bracketLevel++
                    if (inputString[index] == closeChar) {
                        if (bracketLevel == 0) {
                            resultArrayList.add(inputString.substring(indexedValue.index + 1 until index))
                            break
                        } else bracketLevel--
                    }
                }
            }
        }
        return resultArrayList.toTypedArray()
    }
}
