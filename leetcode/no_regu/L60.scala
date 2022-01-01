object L60 {
    // eg n = 3, k = 3, 可以简单判断出来，当第一个数确定时，后面排列序号的范围是确定的，可以通过不断缩小范围确定最后序号
    // 每次循环，确定一个位置上的数选什么; 循环不变式
    def getPermutation(n: Int, _k: Int): String = {
        var res = ""
        var k = _k
        
        val fact: Array[Int] = Array.ofDim(n + 1 + 1) // 表示index的阶乘值
        val nums = collection.mutable.ListBuffer[Int]()
        fact(0) = 1
        for (i <- 1 to n) {
            fact(i) = fact(i - 1) * i
            nums += i
        }

        for (i <- (0 until n).reverse) {
            // 选第几个数, k - 1 的意思是, 如果恰好整除，要选择前一个数
            val numIndex = (k - 1) / fact(i)
            res += nums.remove(numIndex)
            k -= numIndex * fact(i)
        }
        res
    }
}