object L46 {

    private var res: collection.mutable.ListBuffer[List[Int]] = null

    private var path: collection.mutable.Stack[Int] = null

    private var visited: Array[Boolean] = null

    // dfs，枚举每个位置可以放什么数
    def permute(arr: Array[Int]): List[List[Int]] = {
        res = collection.mutable.ListBuffer[List[Int]]()
        path = collection.mutable.Stack[Int]()
        visited = new Array[Boolean](arr.length)

        dfs(arr, 0)
        res.toList
    }

    private def dfs(arr: Array[Int], index: Int) {
        if (index == arr.length) {
            res += path.toList.reverse
            return
        }

        for (i <- arr.indices if !visited(i)) {
            // store state
            visited(i) = true
            path.push(arr(i))
            dfs(arr, index + 1)
            // restore state
            visited(i) = false
            path.pop
        }
    }
}