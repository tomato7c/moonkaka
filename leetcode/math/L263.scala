object Solution {
    def isUgly(_n: Int): Boolean = {
        var n = _n
        if (n <= 0) return false
        while (n % 5 == 0) n /= 5
        while (n % 3 == 0) n /= 3
        while (n % 2 == 0) n /= 2
        n == 1
    }
}