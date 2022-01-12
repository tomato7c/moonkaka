object L136 {
	// 异或消除
    def singleNumber(arr: Array[Int]): Int = {
        arr.reduce(_^_)
    }
}