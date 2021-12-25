object L31 {

    def main(args: Array[String]): Unit = {
        var arr = Array(1, 2, 4, 3)
        nextPermutation(arr)
        AssertHelper.assertEquals(arr, Array(1, 3, 2, 4))

        arr = Array(3, 2, 1)
        nextPermutation(arr)
        AssertHelper.assertEquals(arr, Array(1, 2, 3))

        arr = Array(2, 1, 1, 1)
        nextPermutation(arr)
        AssertHelper.assertEquals(arr, Array(1, 1, 1, 2))
    }

    def nextPermutation(arr: Array[Int]): Unit = {
        // 从后向前找到第一个降序位置
        var i = arr.length - 2
        while (i >= 0 && arr(i) >= arr(i + 1)) i -= 1
        if (i == -1) {
            reverse(arr, 0)
            return
        }
        // 此时arr(i) < arr(i + 1)，从末尾找到第一个大于等于arr(i)的元素
        var j = arr.length - 1
        while (arr(j) <= arr(i)) j -= 1
        // 交换arr(i), arr(j)，并对i后元素reverse
        swap(arr, i, j)
        reverse(arr, i + 1)
    }

    private def reverse(arr: Array[Int], start: Int) {
        var a = start
        var b = arr.length - 1
        while (a < b) {
            swap(arr, a, b)
            a += 1
            b -= 1
        }
    }

    private def swap(arr: Array[Int], a: Int, b: Int) {
        val temp = arr(a)
        arr(a) = arr(b)
        arr(b) = temp
    }
}