object L78 {
    private var res: collection.mutable.ListBuffer[List[Int]] = null

    private var path: collection.mutable.Stack[Int] = null
    // 2^n，枚举每个数选择 or 不选择
    def subsets(arr: Array[Int]): List[List[Int]] = {
        res = collection.mutable.ListBuffer[List[Int]]()
        path = collection.mutable.Stack[Int]()

        dfs(arr, 0)
        res.toList
    }

    // 结果有2^n个，可以借助二进制
    def subsetsV2(arr: Array[Int]): List[List[Int]] = {
        res = collection.mutable.ListBuffer[List[Int]]()
        for (i <- 0 until 1 << arr.length) {
            val path = collection.mutable.ListBuffer[Int]()
            for (j <- 0 until arr.length) {
                if (((i >> j) & 1) == 1) path += arr(j)
            }
            res += path.toList
        }
        res.toList
    }

    private def dfs(arr: Array[Int], index: Int) {
        if (index == arr.length) {
            res += path.toList.reverse
            return
        }
        // 不选择
        dfs(arr, index + 1) 
        // 选择
        path.push(arr(index))
        dfs(arr, index + 1)
        path.pop
    }
}