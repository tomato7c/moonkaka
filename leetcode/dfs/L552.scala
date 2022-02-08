object Solution {

    private val mod = (1e9 + 7).toInt

    private val cache = collection.mutable.Map[String, Int]()

    def checkRecord(n: Int): Int = {
        dfs(n, 0, 0)
    }

    // dfs每个状态，remain表示剩余天数，absent 缺勤天数, late 连续迟到次数
    // 返回可奖励方案数量
    private def dfs(remain: Int, absent: Int, late: Int): Int = {
        if (remain == 0) return 1
        val key = s"$remain,$absent,$late"
        if (cache.contains(key)) return cache(key)
        var res = 0
        // 到场
        res += dfs(remain - 1, absent, 0) % mod
        // 缺勤
        if (absent + 1 <= 1) res += dfs(remain - 1, absent + 1, 0) % mod
        // 迟到
        if (late + 1 <= 2) res += dfs(remain - 1, absent, late + 1) % mod
        res %= mod
        cache += (key -> res)
        res
    }
}