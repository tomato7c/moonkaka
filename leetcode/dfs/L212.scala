object L212 {
    private var res: collection.mutable.ListBuffer[String] = null

  // 每个位置向四周dfs, 类比组合总和-记录访问状态
  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
    res = collection.mutable.ListBuffer[String]()
    val root = buildTrieFrom(words)

    for (i <- board.indices; j <- board(0).indices) dfs(board, i, j, root)
    res.toList
  }

  private def dfs(board: Array[Array[Char]], i: Int, j: Int, node: TrieNode): Unit = {
    // 能不能dfs当前位置，以及dfs时是不是答案集
    val c = board(i)(j); val diff = c - 'a'
    if (c == '*' || node.next(diff) == null) return
    val cur = node.next(diff)

    if (cur.word != null) {
      res += cur.word
      cur.word = null // de-duplicate
    }
    board(i)(j) = '*' // store status
    if (i - 1 >= 0) dfs(board, i - 1, j, cur)
    if (i + 1 < board.length) dfs(board, i + 1, j, cur)
    if (j - 1 >= 0) dfs(board, i, j - 1, cur)
    if (j + 1 < board(0).length) dfs(board, i, j + 1, cur)
    // restore
    board(i)(j) = c
  }

  private def buildTrieFrom(words: Array[String]): TrieNode = {
    val root = new TrieNode
    for (s <- words) {
      var cur = root
      for (c <- s) {
        val diff = c - 'a'
        if (cur.next(diff) == null) cur.next(diff) = new TrieNode
        cur = cur.next(diff)
      }
      cur.word = s
    }

    root
  }

  class TrieNode {
    var word: String = null
    val next = new Array[TrieNode](26)
  }
}