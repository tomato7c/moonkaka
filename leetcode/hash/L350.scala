object Solution {
    // 次数不一致取最小值，使用哈希表维护次数，次数为 <= 0时不添加
    def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        val map = collection.mutable.Map[Int, Int]()
        for (v <- nums1) map += (v -> (map.getOrElse(v, 0) + 1))
        
        val res = collection.mutable.ListBuffer[Int]()
        for (v <- nums2 if map.getOrElse(v, 0) > 0) {
            map(v) -= 1
            res += v
        }
        res.toArray
    }
}