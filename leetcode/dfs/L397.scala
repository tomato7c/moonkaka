object Solution {
    def integerReplacement(n: Int): Int = {
        dfs(n.toLong)
    }

    private def dfs(n: Long): Int = {
        if (n == 1) return 0
        if (n % 2 == 0) return dfs(n / 2) + 1
        math.min(dfs(n + 1), dfs(n - 1)) + 1
    }
}