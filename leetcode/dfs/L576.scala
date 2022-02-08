object Solution {

    private val mod = (1e9 + 7).toInt
    private var m = -1
    private var n = -1
    private var cache: Array[Array[Array[Int]]] = null
    private val vectors = Array((1, 0), (-1, 0), (0, 1), (0, -1))

    def findPaths(_m: Int, _n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int = {
        m = _m; n = _n
        cache = Array.fill(maxMove + 1, m, n)(-1)
        
        dfs(maxMove, startRow, startColumn)
    }

    // remain表示剩余步数
    // x,y为当前坐标
    private def dfs(remain: Int, x: Int, y: Int): Int = {
        def out(x: Int, y: Int): Boolean = x < 0 || x >= m || y < 0 || y >= n

        if (out(x, y)) return 1
        if (remain == 0) return 0
        if (cache(remain)(x)(y) != -1) return cache(remain)(x)(y)
        // 怎么移动也不会出去，剪枝
        // if (!out(x - remain, y) && !out(x + remain, y) && !out(x, y - remain) && !out(x, y + remain)) return 0
        var res = 0
        for ((dx, dy) <- vectors) {
            res = (res + dfs(remain - 1, x + dx, y + dy)) % mod
        }
        cache(remain)(x)(y) = res
        res
    }
}