object L334 {
    // 循环
    def increasingTriplet(arr: Array[Int]): Boolean = {
        var a = Int.MaxValue; var b = Int.MaxValue
        for (v <- arr) {
            if (v <= a) a = v
            else if (v <= b) b = v
            else return true
        }
        false
    }
}