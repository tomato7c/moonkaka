object Solution {
    def firstUniqChar(s: String): Int = {
        val count = new Array[Int](256)
        for (c <- s) count(c) += 1
        for (i <- s.indices) {
            if (count(s(i)) == 1) return i
        }
        -1
    }
}