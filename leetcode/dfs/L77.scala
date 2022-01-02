object L77 {
    private var res: collection.mutable.ListBuffer[List[Int]] = null

    private var path: collection.mutable.Stack[Int] = null

    private var n = -1

    // 如何避免重复 -> 人为规定枚举顺序
    // eg 第一个数从选0，则第二个数范围在1 to xxx
    def combine(_n: Int, k: Int): List[List[Int]] = {
        res = collection.mutable.ListBuffer[List[Int]]()
        path = collection.mutable.Stack[Int]()
        n = _n

        dfs(k, 1)
        res.toList
    }

    private def dfs(remain: Int, _start: Int) {
        if (remain == 0) {
            res += path.toList.reverse
            return
        }

        var start = _start
        while (start <= n - remain + 1) {
            path.push(start)
            dfs(remain - 1, start + 1)
            path.pop

            start += 1
        }
    }
}