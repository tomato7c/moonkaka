object Solution {

    var lower = -1
    var upper = -1

    // 归并排序时，可以方便的计算s[j] - s[i]在[lower, upper]之内的数量
    def countRangeSum(nums: Array[Int], _lower: Int, _upper: Int): Int = {
        lower = _lower
        upper = _upper
        val prefix = new Array[Long](nums.length + 1)
        prefix(0) = 0
        for (i <- nums.indices) prefix(i + 1) = prefix(i) + nums(i)
        mergeSort(prefix, 0, prefix.length - 1)
    }

    private def mergeSort(arr: Array[Long], l: Int, r: Int): Int = {
        if (l >= r) return 0

        var count = 0
        val mid = l + r >>> 1
        count += mergeSort(arr, l, mid)
        count += mergeSort(arr, mid + 1, r)
        // 以left为左端点，[a, b)为候选右端点
        var a, b = mid + 1
        for (_left <- l to mid) {
            val left = arr(_left)
            // 为什么a,b不需要初始化？类似滑动窗口的思路，前面已经滑过的数一定不在候选集合内
            while (a <= r && arr(a) - left < lower) a += 1 // 让 diff >= lower
            while (b <= r && arr(b) - left <= upper ) b += 1 // 让 diff > upper
            count += b - a
        }
        merge(arr, l, mid, r)
        count
    }

    private def merge(arr: Array[Long], l: Int, m: Int, r: Int) {
        val temp = collection.mutable.ListBuffer[Long]()
        var p = l; var q = m + 1
        while (p <= m && q <= r) {
            if (arr(p) < arr(q)) {
                temp += arr(p)
                p += 1
            } else {
                temp += arr(q)
                q += 1
            }
        }
        while (p <= m) {
            temp += arr(p)
            p += 1
        }
        while (q <= r) {
            temp += arr(q)
            q += 1
        }
        var i = l
        for (v <- temp) {
            arr(i) = v
            i += 1
        }
    }
}