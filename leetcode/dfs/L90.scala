object L90 {

    private var res: collection.mutable.ListBuffer[List[Int]] = null

    private var path: collection.mutable.Stack[Int] = null

    private var visited: Array[Boolean] = null

    // 针对每个元素dfs选择与不选择，重复时要按相对顺序放置
    def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
        res = collection.mutable.ListBuffer[List[Int]]()
        path = collection.mutable.Stack[Int]()
        visited = Array.ofDim(nums.length)
        val arr = nums.sortWith(_<_)

        dfs(arr, 0)
        res.toList
    }

    private def dfs(arr: Array[Int], start: Int) {
        if (start == arr.length) {
            res += path.toList.reverse
            return
        }
        // 不选择
        dfs(arr, start + 1)
        // 选择
        if (start >= 1 && arr(start) == arr(start - 1) && !visited(start - 1)) return
        path.push(arr(start))
        visited(start) = true
        dfs(arr, start + 1)
        visited(start) = false
        path.pop
    }
}