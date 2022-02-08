object Solution {

    private var cache: collection.mutable.Map[String, Int] = null
    private var target = -1

    def findTargetSumWays(arr: Array[Int], _target: Int): Int = {
        cache = collection.mutable.Map[String, Int]()
        target = _target
        dfs(arr, 0, 0)
    }
    // 以index为起点，sum为初始和的状态下，组成target的不同表达式数目
    private def dfs(arr: Array[Int], index: Int, sum: Int): Int = {
        if (index == arr.length) {
            return if (sum == target) 1 else 0
        }
        val key = s"$index,$sum"
        if (cache.contains(key)) return cache(key)
        var res = 0
        res += dfs(arr, index + 1, sum - arr(index))
        res += dfs(arr, index + 1, sum + arr(index))
        cache += (key -> res)
        res
    }
}