object L93 {

    private var res: collection.mutable.ListBuffer[String] = null

    private var path: collection.mutable.Stack[String] = null

    // dfs每一阶段的数，需要剪枝
    def restoreIpAddresses(s: String): List[String] = {
        res = collection.mutable.ListBuffer[String]()
        path = collection.mutable.Stack[String]()

        dfs(s, 1, 0)
        res.toList
    }

    // stage in [1, 4]
    private def dfs(s: String, stage: Int, start: Int) {
        if (stage == 5) {
            if (start == s.length) res += path.toList.reverse.mkString(".")
            return
        }

        val remainSize = s.length - start
        val remainStage = 4 - stage + 1
        if (remainSize < remainStage || remainSize > 3 * remainStage) return

        // 取一位
        path.push(s.substring(start, start + 1))
        dfs(s, stage + 1, start + 1)
        path.pop
        // 剪枝
        if (s(start) == '0') return
        // 取两位
        if (start + 2 <= s.length) {
            path.push(s.substring(start, start + 2))
            dfs(s, stage + 1, start + 2)
            path.pop
        }
        // 取三位, 剪枝
        if (start + 3 <= s.length && s.substring(start, start + 3).toInt <= 255) {
            path.push(s.substring(start, start + 3))
            dfs(s, stage + 1, start + 3)
            path.pop
        }
    }


}