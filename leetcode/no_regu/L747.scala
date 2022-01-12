object L747 {
    def dominantIndex(arr: Array[Int]): Int = {
        var a, b = Int.MinValue
        var index = -1
        for (i <- arr.indices) {
            val v = arr(i)
            if (v > a) {
                b = a
                a = v
                index = i
            } else if (v > b) {
                b = v
            }
        }
        if (a.toLong >= (2 * b).toLong) index else -1
    }
}