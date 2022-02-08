object Solution {
    def findTheDifference(s: String, t: String): Char = {
        val count = new Array[Int](26)
        for (c <- s) count(c - 'a') += 1
        for (c <- t) {
            count(c - 'a') -= 1
            if (count(c - 'a') < 0) return c
        }
        ' '
    }
}