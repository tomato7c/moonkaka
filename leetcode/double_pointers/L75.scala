object L75 {
    // 0,0,1,1,1,2
    // i维护0的末尾
    // j维护2的首位
    def sortColors(arr: Array[Int]): Unit = {
        var i = -1; var cur = 0; var j = arr.length
        while (cur < j) {
            arr(cur) match {
                case 0 => {
                    i += 1
                    swap(arr, i, cur)
                    cur += 1
                }
                case 1 => cur += 1
                case 2 => {
                    j -= 1
                    swap(arr, cur, j)
                }
            }
        }
    }

    private def swap(arr: Array[Int], a: Int, b: Int) {
        val temp = arr(a)
        arr(a) = arr(b)
        arr(b) = temp
    }
}