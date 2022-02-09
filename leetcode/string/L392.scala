object Solution {
    def isSubsequence(s: String, t: String): Boolean = {
        var i = 0
        for (j <- s.indices) {
            val c = s(j)
            while (i < t.length && t(i) != c) i += 1
            if (i >= t.length) return false
            i += 1
        }
        true
    }
}