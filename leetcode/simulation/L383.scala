object Solution {
    def canConstruct(ransomNote: String, magazine: String): Boolean = {
        val count = new Array[Int](256)
        for (c <- magazine) count(c) += 1

        for (c <- ransomNote) {
            count(c) -= 1
            if (count(c) < 0) return false
        }
        true
    }
}