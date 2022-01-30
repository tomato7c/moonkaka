object Solution {
    def reverseString(s: Array[Char]): Unit = {
        var l = 0; var r = s.length - 1
        while (l < r) {
            val temp = s(l)
            s(l) = s(r)
            s(r) = temp
            l += 1; r -= 1
        }
    }
}