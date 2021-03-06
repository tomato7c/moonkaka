object Solution {
    /*               i-2
    case 1 : i-1┌─┐
                └─┼─>i
                 i-3
                 
                    i-2
    case 2 : i-1 ┌────┐
                 └─══>┘i-3
                 i  i-4      (i overlapped i-4)

    case 3 :    i-4
               ┌──┐ 
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2

*/
    // 我也不知道为什么这样子，翻译图形...
    def isSelfCrossing(arr: Array[Int]): Boolean = {
        if (arr.length < 3) return false
        for (i <- 3 until arr.length) {
            if (arr(i - 1) <= arr(i - 3) && arr(i) >= arr(i - 2)) return true
            if (i >= 4 && arr(i - 1) == arr(i - 3) && arr(i) + arr(i - 4) >= arr(i - 2)) return true
            if (i >= 5 && arr(i - 1) <= arr(i - 3) && arr(i - 1) + arr(i - 5) >= arr(i - 3) && arr(i) + arr(i - 4) >= arr(i - 2) && arr(i - 2) >= arr(i - 4)) return true
        }
        false
    }
}