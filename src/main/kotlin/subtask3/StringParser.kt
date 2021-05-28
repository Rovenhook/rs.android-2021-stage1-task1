package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val arr: MutableList<String> = mutableListOf()
        val chArr = arrayOf('(', '[', '<')
        var i: Int = 0

        while (i < inputString.length - 1) {
            if (chArr.contains(inputString[i])) {
                val ch = when {
                    inputString[i] == '(' -> ')'
                    inputString[i] == '[' -> ']'
                    else -> '>'
                }
                var count = 1
                for (j in i + 1 until inputString.length) {
                    when {
                        inputString[j] == inputString[i] -> count++
                        inputString[j] == ch -> count--
                    }
                    if (count == 0) {
                        arr.add(inputString.substring(i + 1..j - 1))
                        break
                    }
                }
            }
            i++
        }
        return arr.toTypedArray()
    }
}

