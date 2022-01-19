object L216 {

    private var res: collection.mutable.ListBuffer[List[Int]] = null

    private var path: collection.mutable.Stack[Int] = null

    private var n = -1

    private var k = -1

    def combinationSum3(_k: Int, _n: Int): List[List[Int]] = {
        res = collection.mutable.ListBuffer[List[Int]]()
        path = collection.mutable.Stack[Int]()
        n = _n
        k = _k

        dfs(0, 0)
        res.toList
    }

    private def dfs(index: Int, sum: Int) {
        if (index == k) {
            if (sum == n) res += path.toList.reverse
            return
        }
        for (i <- 1 to 9) {
            if (path.isEmpty || path.top < i) {
                path.push(i)
                dfs(index + 1, sum + i)
                path.pop
            }
        }
    }
}