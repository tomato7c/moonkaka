object Solution {

    private var map: collection.mutable.Map[Int, Int] = null // value -> index

    private var cache: collection.mutable.Set[(Int, Int)] = null

    def canCross(stones: Array[Int]): Boolean = {
        if (stones.length < 2) return true
        map = collection.mutable.Map[Int, Int]()
        cache = collection.mutable.Set[(Int, Int)]()
        for (i <- stones.indices) map += (stones(i) -> i)
        // 第一步只能从单元格1跳至单元格2
        if (stones(1) != stones(0) + 1) return false
        dfs(stones, 1, 1)
    }

    private def dfs(stones: Array[Int], cur: Int, step: Int): Boolean = {
        val n = stones.length
        if (cur == n - 1) return true
        if (cache.contains((cur, step))) return false

        // for -1, 0, 1
        for (offset <- -1 to 1) {
            val next = stones(cur) + step + offset // 要跳的位置
            if (next > stones(cur) && map.contains(next)) {
                if (dfs(stones, map(next), step + offset)) return true
            }
        }
        cache.addOne((cur, step))
        false
    }
}