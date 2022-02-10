object Solution {
    def lexicalOrder(n: Int): List[Int] = {
        val res = collection.mutable.ListBuffer[Int]()

        def dfs(cur: Int): Unit = {
            if (cur > n) return
            res += cur
            for (candidate <- cur * 10 to cur * 10 + 9) dfs(candidate)
        }

        for (candidate <- 1 to 9) dfs(candidate)
        res.toList
    }
}

object Solution {
    def lexicalOrder(n: Int): List[Int] = {
        var res = collection.mutable.ListBuffer[Int]()
        var cur = 1
        while (res.length < n) {
            while (cur <= n) { // dfs下层
                res += cur
                cur *= 10
            }
            // 回溯
            while (cur > n || cur % 10 == 9) cur /= 10
            // 继续搜索当前层下个节点
            cur += 1
        }
        res.toList
    }
}
