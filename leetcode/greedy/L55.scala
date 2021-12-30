object L55 {
    def canJump(arr: Array[Int]): Boolean = {
        var area = 0
        for (index <- arr.indices) {
            if (area < index) return false
            area = Math.max(area, index + arr(index))
        }
        true
    }
}