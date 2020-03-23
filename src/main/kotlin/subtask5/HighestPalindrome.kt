package subtask5

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var moves = 0 //количество сделанных ходов
        for (i in 0 until n / 2) { //проверка на палиндром и запись количества ходов, которые потребуются чтобы сделать строку палиндромом
            if (digitString[i] != digitString[n - 1 - i]) {
                moves++
            }
        }
        if (moves > k) {
            return "-1" //если ходов нужно сделать больше, чем позволено, то вернуть -1
        }
        val result = digitString.toMutableList() //результат
        for (i in 0 until n / 2) {
            if (digitString[i] < digitString[n - 1 - i]) { //проверка равенства символов
                result[i] = result[n - 1 - i] //меняем меньший символ на больший
                moves--
            } else if (digitString[i] > digitString[n - 1 - i]) { //проверка равенства символов
                result[n - 1 - i] = result[i] //меняем больший символ на меньший
                moves--
            }
        }
        moves = k - moves //считаем сколько ходов еще можно сделать

        var i = 0
        while (moves > 1) { //пока еще есть ходы
            if (result[i] != '9') { //по возможности меняем цифру на большую
                result[i] = '9'
                result[n - 1 - i] = '9'
                moves -=2
            }
            i++
        }

        if (moves == 1 && n % 2 == 1) { //меняем центральную цифру на 9
            result[n / 2] = '9'
        }

        val stringBuilder = StringBuilder()
        result.forEach { stringBuilder.append(it) }
        return stringBuilder.toString()
    }
}
