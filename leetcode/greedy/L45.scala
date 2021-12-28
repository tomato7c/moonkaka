object L45 {
    // 贪心，想象成按层次移动
    def jump(arr: Array[Int]): Int = {
        var steps = 0
        var end = 0
        var maxNextIndex = 0
        for (index <- 0 until arr.length - 1) {
            maxNextIndex = Math.max(maxNextIndex, index + arr(index))
            if (index == end) {
                steps += 1
                end = maxNextIndex
            }
        }
        steps
    }
}