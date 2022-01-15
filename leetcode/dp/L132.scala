// 区间dp
object L132 {

    private var isPalindrome: Array[Array[Boolean]] = null

    // f(i)表示前i个字符最小分割次数；集合可以按最后一段区间长度划分1,2,3,4
    def minCut(s: String): Int = {
        isPalindrome = Array.ofDim(s.length, s.length)
        // init
        for (j <- 0 until s.length; i <- 0 to j if s(i) == s(j)) {
            if (i + 1 > j - 1 || isPalindrome(i + 1)(j - 1)) isPalindrome(i)(j) = true
        }

        // f = min.before + 1
        val f = new Array[Int](s.length)
        for (i <- 0 until f.length) f(i) = Int.MaxValue
        f(0) = 0
        // [0,i] = [a,mid - 1] + [mid,c]
        for (i <- 1 until s.length; mid <- 0 to i) {
            if (mid == 0 && isPalindrome(0)(i)) { // [0, i]是回文
                f(i) = 0
            } else {
                if (isPalindrome(mid)(i) && f(mid - 1) != Int.MaxValue) {
                    f(i) = Math.min(f(i), f(mid - 1) + 1)
                }
            }
        }
        f.last
    }
}   