object L135 {
    // 先从左到右，再从右到左；最后每个值取max
    def candy(ratings: Array[Int]): Int = {
        val n = ratings.length
        val left = new Array[Int](n)
        val right = new Array[Int](n)

        for (i <- 1 until n if ratings(i) > ratings(i - 1)) left(i) = left(i - 1) + 1
        for (i <- (0 until n - 1).reverse if (ratings(i) > ratings(i + 1))) right(i) = right(i + 1) + 1

        var count = 0
        for (i <- 0 until n) count += Math.max(left(i), right(i))
        count + n
    }
}