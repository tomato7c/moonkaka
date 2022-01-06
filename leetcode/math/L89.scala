object L89 {
    // 镜像反射...没啥逻辑
    def grayCode(n: Int): List[Int] = {
        val res = collection.mutable.ListBuffer[Int]()
        res += 0
        for (i <- 0 until n) {
            val add = 1 << i
            val list = res.toList.reverse
            for (v <- list) {
                res += v + add
            }
        }
        res.toList
    }
}