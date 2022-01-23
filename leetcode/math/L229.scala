object L229 {
    // 摩尔投票法...; k = 3的情况下，想象有两个仓库，分别用两个仓库中的物品抵消
    // 假设x0是众数之一，要证明一次pass后，x0被留存下来
    // case x0 如果没留存过 => 不可能，因为每个x0会消耗其他x1,x2两个数，在x0 > n/3的情况下一定能留存
    // case x0留存，但被逐出 => 也不可能，每个x0的消耗都会导致x1,x2陪葬，3X0 严格大于 n
    def majorityElement(arr: Array[Int]): List[Int] = {
        var x0, c0, x1, c1 = 0
        for (v <- arr) {
            if (v == x0) {
                c0 += 1
            } else if (v == x1) {
                c1 += 1
            } else if (c0 == 0) {
                x0 = v
                c0 = 1
            } else if (c1 == 0) {
                x1 = v
                c1 = 1
            } else {
                c0 -= 1
                c1 -= 1
            }
        }
        c0 = 0; c1 = 0
        for (v <- arr) {
            if (v == x0) c0 += 1
            else if (v == x1) c1 += 1
        }
        val res = collection.mutable.ListBuffer[Int]()
        if (c0 > arr.length / 3) res += x0
        if (c1 > arr.length / 3) res += x1
        res.toList
    }
}