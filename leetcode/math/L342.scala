object Solution {
    def isPowerOfFour(n: Int): Boolean = {
        if (n <= 0) return false
        var remain = n
        while ((remain % 4) == 0) {
            remain /= 4
        }
        remain == 1
    }
}