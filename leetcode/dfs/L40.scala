object L40 {

    private var res: collection.mutable.ListBuffer[List[Int]] = null

    private var path: collection.mutable.Stack[Int] = null
    // 枚举每个数出现的次数，注意要排序
    def combinationSum2(_candidates: Array[Int], target: Int): List[List[Int]] = {
        res = collection.mutable.ListBuffer[List[Int]]()
        path = collection.mutable.Stack[Int]()
        val candidate = _candidates.sortWith(_<_)

        dfs(candidate, 0, target)
        res.toList
    }

    private def dfs(candidate: Array[Int], index: Int, target: Int) {
        if (target == 0) {
            res += path.toList.reverse
            return
        }
        // 枚举到结尾
        if (index == candidate.length) return
        
        // 统计数量
        val v = candidate(index)
        var nextIndex = index + 1
        while (nextIndex < candidate.length && candidate(nextIndex) == v) nextIndex += 1
        val dupSize = nextIndex - index
        for (count <- 0 to dupSize if count * v <= target) {
            if (count > 0) path.push(v)
            dfs(candidate, nextIndex, target - count * v)
        }
        // restore
        while (path.nonEmpty && path.top == v) path.pop
    }
}