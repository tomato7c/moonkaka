object Solution {
    def palindromePairs(words: Array[String]): List[List[Int]] = {
        var res  = collection.mutable.ListBuffer[List[Int]]()
        val map = collection.mutable.Map[String, Int]()
        for (i <- words.indices) map += (words(i).reverse -> i)

        for (i <- words.indices) {
            val s = words(i)
            for (k <- 0 to s.length) {
                // s作为a + b中的a; 同时考虑a,b相等的情况
                val left = s.substring(0, k); val right = s.substring(k)
                if (isPalindrome(right) && map.contains(left) && map(left) != i) res += List(i, map(left))
                // s作为a + b中的b, 过滤a,b相等的情况(答案去重)
                if (isPalindrome(left) 
                && map.contains(right)
                && map(right) != i 
                && right.size != s.size) res += List(map(right), i)
            }
        }
        res.toList
    }

    private def isPalindrome(s: String): Boolean = {
        var l = 0; var r = s.length - 1
        while (l < r) {
            if (s(l) != s(r)) return false
            l += 1; r -= 1
        }
        true
    }
}