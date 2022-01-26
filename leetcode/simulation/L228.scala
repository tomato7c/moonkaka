object Solution {
    def summaryRanges(arr: Array[Int]): List[String] = {
        if (arr.length < 1) return List()
        val res = collection.mutable.ListBuffer[String]()
        var cur = (arr(0), arr(0))
        for (v <- arr) {
            if (v >= cur._1 && v <= cur._2) {
                // do nothing
            } else if (v == cur._2 + 1) {
                cur = (cur._1, v)
            } else {
                res.append(if (cur._1 == cur._2) cur._1.toString else s"${cur._1}->${cur._2}")
                cur = (v, v)
            }
        }
        val last = if (cur._1 == cur._2) cur._1.toString else s"${cur._1}->${cur._2}"
        if (res.isEmpty || !res.last.equals(last)) res += last
        res.toList
    }
}