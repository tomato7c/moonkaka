object Solution {
    def maxNumberOfBalloons(text: String): Int = {
        val count = new Array[Int](256)
        for (c <- text) count(c) += 1
        var res = Int.MaxValue
        res = math.min(res, count('b'))
        res = math.min(res, count('a'))
        res = math.min(res, count('l') / 2)
        res = math.min(res, count('o') / 2)
        res = math.min(res, count('n'))
        res
    }
}