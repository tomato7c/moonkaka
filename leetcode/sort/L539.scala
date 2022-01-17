object L539 {
    // 转换成分钟再排序
    def findMinDifference(timePoints: List[String]): Int = {
        val arr = timePoints.map(toMinutes).sortWith(_<_).toList
        var res = 60 * 24 - (arr.last - arr.head)
        for (i <- 1 until arr.length) res = Math.min(res, arr(i) - arr(i - 1))
        res
    }

    private def toMinutes(s: String): Int = {
        val arr = s.split(":")
        var res = 0
        res += arr(0).toInt * 60
        res += arr(1).toInt
        res
    }
}