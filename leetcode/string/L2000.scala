object Solution {
    def reversePrefix(word: String, ch: Char): String = {
        var l = 0; var r = indexOf(word, ch)
        val arr = word.toArray
        while (l < r) {
            val temp = arr(l)
            arr(l) = arr(r)
            arr(r) = temp
            l += 1; r -= 1
        }

        new String(arr)
    }

    private def indexOf(s: String, target: Char): Int = {
        for (i <- s.indices if s(i) == target) return i
        -1
    }
}