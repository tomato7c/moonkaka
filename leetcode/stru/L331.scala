object Solution {
    // 统计出度入度,节点贡献一个入度，两个出度，null贡献1个入度
    def isValidSerialization(preorder: String): Boolean = {
        val arr = preorder.split(",")
        var diff = 1 // 出度-入度
        for (c <- arr) {
            diff -= 1 // 每个节点都减去一个入度
            if (diff < 0) return false
            if (!c.equals("#")) diff += 2
        }
        diff == 0
    }
}