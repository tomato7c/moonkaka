object Solution {
    // i是奇数，1的个数为前面的偶数1个数-1
    // i是偶数，与消去末尾0的，1的个数一致
    def countBits(n: Int): Array[Int] = {
        val res = new Array[Int](n + 1)
        res(0) = 0
        for (i <- 1 to n) {
            if (isOdd(i)) {
                res(i) = res(i - 1) + 1
            } else {
                res(i) = res(i >> 1)
            }
        }
        res
    }

    private def isOdd(x: Int): Boolean = (x & 1) == 1
}