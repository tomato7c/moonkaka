object L47 {

    private var res: collection.mutable.ListBuffer[List[Int]] = null

    private var path: collection.mutable.Stack[Int] = null

    private var visited: Array[Boolean] = null

    // 可以规定相同元素，相对位置不发生改变；即如果判断arr(i-1)=arr(i),但是arr(i-1)未用到，需要减掉这个分支
    def permuteUnique(_arr: Array[Int]): List[List[Int]] = {
        val arr = _arr.sortWith(_<_)
        res = collection.mutable.ListBuffer[List[Int]]()
        path = collection.mutable.Stack[Int]()
        visited = new Array[Boolean](arr.length)

        dfs(arr, 0)
        res.toList
    }

    private def dfs(arr: Array[Int], cur_index: Int) {
        if (cur_index == arr.length) {
            res += path.toList.reverse
            return
        }

        for (i <- arr.indices if !visited(i)) {
            if (i - 1 >= 0 && arr(i - 1) == arr(i) && !visited(i - 1)) {

            } else {
               // store state
                visited(i) = true
                path.push(arr(i))
                dfs(arr, cur_index + 1)
                // restore state
                visited(i) = false
                path.pop
            }
        }
    }
}