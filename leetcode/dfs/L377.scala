object Solution {

    private var cache: collection.mutable.Map[Int, Int] = null

    def combinationSum4(nums: Array[Int], target: Int): Int = {
        cache = collection.mutable.Map[Int, Int]()
        dfs(nums, target)
    }

    // 组成remain的方案数
    private def dfs(arr: Array[Int], remain: Int): Int = {
        if (remain == 0) return 1
        if (cache.contains(remain)) return cache(remain)
        var res = 0
        for (v <- arr if remain >= v) res += dfs(arr, remain - v)
        cache += (remain -> res)
        res
    }
}