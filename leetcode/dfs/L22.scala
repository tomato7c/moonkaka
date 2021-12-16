object L22 {

    var res: collection.mutable.ListBuffer[String] = null
    var n: Int = -1

    def generateParenthesis(_n: Int): List[String] = {
        res = collection.mutable.ListBuffer[String]()
        n = _n

        dfs("", 0, 0)
        res.toList
    }

    private def dfs(s: String, open: Int, close: Int) {
        if (close > open || open > n) return
        if (close == open && open == n) {
            res += s
            return
        }
        
        dfs(s + '(', open + 1, close)
        dfs(s + ')', open, close + 1)
    }
}