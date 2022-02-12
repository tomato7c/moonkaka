object Solution {
    def readBinaryWatch(turnedOn: Int): List[String] = {
        val res = collection.mutable.ListBuffer[String]()
        for (h <- 0 to 11; m <- 0 to 59) {
            if (count(h) + count(m) == turnedOn) {
                if (m < 10) res += s"$h:0$m"
                else res += s"$h:$m"
            }
        }
        res.toList
    }

    private def count(_n: Int): Int = {
        var n = _n
        var res = 0
        while (n > 0) {
            n = n & (n - 1)
            res += 1
        }
        res
    }
}