object Solution {
    // 逆序穿插的目的还是让在原数组中间可能出现的重复值分布在结果数组的两端
    def wiggleSort(arr: Array[Int]): Unit = {
        val n = arr.length
        // 桶排序
        val bucket = new Array[Int](50001)
        for (v <- arr) bucket(v) += 1

        var i = 1; var bucketIndex = 5000
        while (i < n) {
            while (bucket(bucketIndex) == 0) bucketIndex -= 1
            arr(i) = bucketIndex
            bucket(bucketIndex) -= 1
            i += 2
        }
        i = 0
        while (i < n) {
            while (bucket(bucketIndex) == 0) bucketIndex -= 1
            arr(i) = bucketIndex
            bucket(bucketIndex) -= 1
            i += 2
        }
    }
}