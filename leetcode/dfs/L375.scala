object Solution {

    val cache: Array[Array[Int]] = Array.ofDim(201, 201)

    // dfs(l, r)定义为[l, r]内找到数字的最小代价
    def getMoneyAmount(n: Int): Int = {
        dfs(1, n)
    }

    private def dfs(l: Int, r: Int): Int = {
        if (l >= r) return 0 // 区间只有一个元素或麻有时，代价0
        if (cache(l)(r) != 0) return cache(l)(r)
        var res = Int.MaxValue
        for (x <- l to r) { // [l, r]中轮训猜哪个数
            val candidate = math.max(dfs(l, x - 1), dfs(x + 1, r)) + x // 不确定落在哪个区间，故用max
            res = res.min(candidate) // 求最小代价，故用min
        }
        cache(l)(r) = res
        res
    }
}