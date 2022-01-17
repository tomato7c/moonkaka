object L189 {
    // 类似翻转单词
    def rotate(arr: Array[Int], _k: Int): Unit = {
        val k = _k % arr.length
        rotate(arr, 0, arr.length - 1)
        rotate(arr, 0, k - 1)
        rotate(arr, k, arr.length - 1)
    }

    private def rotate(arr: Array[Int], start: Int, end: Int) {
        var l = start; var r = end
        while (l < r) {
            val temp = arr(l)
            arr(l) = arr(r)
            arr(r) = temp
            l += 1; r -= 1
        }
    }
}