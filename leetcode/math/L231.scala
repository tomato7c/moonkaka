object Solution {
    // n & (n - 1)的作用是从右边开始，消除一个"1"
    def isPowerOfTwo(n: Int): Boolean = {
        if (n <= 0) return false
        (n & (n - 1)) == 0
    }
}