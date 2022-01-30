object Solution {
    def isPowerOfThree(_n: Int): Boolean = {
        var n = _n
        if (n <= 0) return false
        while ((n % 3) == 0) n /= 3
        n == 1
    }
}