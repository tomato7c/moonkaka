object Solution {
    // 带状态机的dp
    // s0表示待买，可以走到s1或rest
    // s1表示已买股票，可以卖出走到s2或rest
    // s2表示冷静期，只能到s0
    def maxProfit(price: Array[Int]): Int = {
        val n = price.length
        val s0 = new Array[Int](n)
        val s1 = new Array[Int](n)
        val s2 = new Array[Int](n)

        s0(0) = 0
        s1(0) = -price(0)
        s2(0) = Int.MinValue // default

        for (i <- 1 until n) {
            s0(i) = math.max(s0(i - 1), s2(i - 1))
            s1(i) = math.max(s1(i - 1), s0(i - 1) - price(i))
            s2(i) = s1(i - 1) + price(i)
        }
        math.max(s0(n - 1), s2(n - 1))
    }
}