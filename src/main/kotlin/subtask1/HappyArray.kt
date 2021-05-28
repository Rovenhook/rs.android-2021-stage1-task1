package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        if (sadArray.isEmpty()) {
            return IntArray(0)
        }

        var sad: IntArray = sadArray
        var result: IntArray = IntArray(sad.size)
        var len: Int = 0
        var isHappy: Boolean = false

        while(!isHappy) {
            result[0] = sad[0]
            len++
            isHappy = true

            for(i in 1 until sad.size - 1) {
                if (sad[i] <= sad[i - 1] + sad[i + 1]) {
                    result[len] = sad[i]
                    len++
                } else {
                    isHappy = false
                }
            }

            result[len] = sad[sad.size - 1]
            len++
            if (!isHappy) {
                sad = result.sliceArray(0 until len)
                len = 0
                result = IntArray(sad.size)
            }
        }
        return result
    }
}
