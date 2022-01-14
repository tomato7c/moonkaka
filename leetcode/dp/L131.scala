object L131 {

    private var f: Array[Array[Boolean]] = null

    private var res: collection.mutable.ListBuffer[List[String]] = null

    private var path: collection.mutable.Stack[String] = null

    // 递推f(i,j)表示从i到j是否为回文串；dfs爆搜
    def partition(s: String): List[List[String]] = {
        // init
        res = collection.mutable.ListBuffer[List[String]]()
        path = collection.mutable.Stack[String]()
        f = Array.ofDim(s.length, s.length)
        // f(i,j) = s(i) == s(j) && f(i + 1, j - 1)
        for (j <- 0 until s.length; i <- 0 to j if (s(i) == s(j))) {
            if (i + 1 > j - 1 || f(i + 1)(j - 1)) f(i)(j) = true
        }

        dfs(s, 0)
        res.toList
    }

    // dfs [start, start + 1 to n)
    private def dfs(s: String, start: Int) {
        if (start == s.length) {
            res += path.toList.reverse
            return
        }
        for (end <- start until s.length) {
            if (f(start)(end)) {
                path.push(s.substring(start, end + 1))
                dfs(s, end + 1)
                path.pop
            }
        }
    }
}