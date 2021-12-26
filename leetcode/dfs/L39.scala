object L39 {
    var res: collection.mutable.ListBuffer[List[Int]] = null
    var path: collection.mutable.Stack[Int] = null
    // 暴力dfs, 枚举每个数选多少个
    def combinationSum(candidate: Array[Int], target: Int): List[List[Int]] = {
        res = collection.mutable.ListBuffer[List[Int]]()
        path = collection.mutable.Stack[Int]()

        dfs(candidate, 0, target)
        res.toList
    }

    private def dfs(candidate: Array[Int], index: Int, target: Int) {
        if (target == 0) {
            res += path.toList.reverse
            return
        }
        // 枚举结束
        if (index == candidate.length) return

        var count = 0
        while (count * candidate(index) <= target) {
            dfs(candidate, index + 1, target - count * candidate(index))
            path.push(candidate(index))
            count += 1
        }
        // restore
        while (count > 0) {
            path.pop
            count -= 1
        }
    }
}