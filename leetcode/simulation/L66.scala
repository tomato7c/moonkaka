object L66 {
    def plusOne(digits: Array[Int]): Array[Int] = {
        val res = collection.mutable.ListBuffer[Int]()

        var next = 1
        for (i <- digits.indices.reverse) {
            val v = digits(i) + next
            next = v / 10
            res += v % 10
        }
        if (next > 0) res += next
        res.reverse.toArray
    }
}