class WordDictionary() {

  private val root = new TrieNode(false)

  def addWord(word: String): Unit = {
    var cur = root
    for (c <- word) {
      val diff = c - 'a'
      if (cur.child(diff) == null) cur.child(diff) = new TrieNode(false)
      cur = cur.child(diff)
    }
    cur.isEnd = true
  }

  def search(word: String): Boolean = {
    dfs(word, 0, root)
  }

  private def dfs(s: String, index: Int, cur: TrieNode): Boolean = {
    if (index == s.length) return cur.isEnd
    val c = s(index)
    if (c == '.') {
      for (child <- cur.child if child != null) {
        if (dfs(s, index + 1, child)) return true
      }
      return false
    } else {
      val diff = c - 'a'
      if (cur.child(diff) == null) return false
      else return dfs(s, index + 1, cur.child(diff))
    }
  }

  class TrieNode(var isEnd: Boolean) {
    val child: Array[TrieNode] = Array.ofDim(26)
  }
}
