object Solution {
    // 贪心，不懂了
    def findMinFibonacciNumbers(_k: Int): Int = {
        var n = Int.MaxValue
        val res = collection.mutable.ListBuffer[Int]()
        res += 1
        var a = 1; var b = 1
        while (n > 0) {
            val c = a + b
            a = b
            b = c
            res += c
            n -= c
        }
        var count = 0
        var k = _k
        for (v <- res.reverse if k >= v) {
            k -= v
            count += 1
        }
        count
    }
}