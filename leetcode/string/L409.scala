object Solution {
    def longestPalindrome(s: String): Int = {
        val count = new Array[Int](256)
        for (v <- s) count(v) += 1
        var res = 0
        for (c <- count) {
            if (c % 2 == 0) res += c
            else res += c - 1
        }
        if (res < s.length) res += 1
        res
    }
}