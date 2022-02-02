object Solution {
    // 排序 + 双指针
    def intersect(_arr1: Array[Int], _arr2: Array[Int]): Array[Int] = {
        val arr1 = _arr1.sortWith(_<_)
        val arr2 = _arr2.sortWith(_<_)

        var i, j = 0
        val res = collection.mutable.ListBuffer[Int]()
        while (i < arr1.length && j < arr2.length) {
            val a = arr1(i); val b = arr2(j)
            if (a == b) {
                res += a
                i += 1; j += 1
            } else if (a > b) {
                j += 1
            } else if (a < b) {
                i += 1
            }
        }
        res.toArray
    }
}