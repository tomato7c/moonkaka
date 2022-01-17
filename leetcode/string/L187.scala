object L187 {
    // 简单双指针枚举每个可能case
    def findRepeatedDnaSequences_v1(s: String): List[String] = {
        val res = collection.mutable.ListBuffer[String]()
        val map = collection.mutable.Map[String, Int]()

        for (i <- s.indices if i + 10 <= s.length) {
            val sub = s.substring(i, i + 10)
            var count = map.getOrElse(sub, 0)
            if (count == 1) res += sub
            map.addOne(sub, count + 1)
        }
        res.toList
    }
}