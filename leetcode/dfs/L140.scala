object L140 {

    private var wordDict: Set[String] = null

    private var res: collection.mutable.ListBuffer[String] = null

    private var path: collection.mutable.Stack[String] = null

    def wordBreak(s: String, _wordDict: List[String]): List[String] = {
        wordDict = Set.from(_wordDict)
        res = collection.mutable.ListBuffer[String]()
        path = collection.mutable.Stack[String]()
        
        dfs(s, 0)
        res.toList
    }

    private def dfs(s: String, start: Int) {
        if (start == s.length) {
            res += path.toList.reverse.mkString(" ")
            return
        }
        for (end <- start until s.length) {
            val sub = s.substring(start, end + 1)
            if (wordDict.contains(sub)) {
                path.push(sub)
                dfs(s, end + 1)
                path.pop
            }
        }
    }
}