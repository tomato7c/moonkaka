class Trie() {

    val root = new TrieNode(false)

    class TrieNode(var isEnd: Boolean) {
        var child: Array[TrieNode] = Array.ofDim(26)
    }

    def insert(word: String): Unit = {
        var cur = root
        for (c <- word) {
            val diff = c - 'a'
            if (cur.child(diff) == null) cur.child(diff) = new TrieNode(false)
            cur = cur.child(diff)
        }
        cur.isEnd = true
    }

    def search(word: String): Boolean = {
        if (word.isEmpty) return true
        var cur = root
        for (c <- word) {
            val diff = c - 'a'
            if (cur.child(diff) == null) return false
            cur = cur.child(diff)
        }
        cur.isEnd
    }

    def startsWith(prefix: String): Boolean = {
        if (prefix.isEmpty) return true
        var cur = root
        for (c <- prefix) {
            val diff = c - 'a'
            if (cur.child(diff) == null) return false
            cur = cur.child(diff)
        }
        true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
