object L223 {
    // 先想象一维的情况，两条线段[a,b],[c,d]并集size=全集-交集；交集左端点 = max(a,c), 右端点=min(b,d)
    // 对应到二维情况，需要确认交集矩形在x轴投影的长度，及在y轴投影的长度
    def computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int = {
        val inter = intersact(ax1, bx1, ax2, bx2) * intersact(by1, ay1, by2, ay2)
        (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - inter
    }

    private def intersact(a: Int, b: Int, c: Int, d: Int): Int = {
        val first = math.max(a, b)
        val second = math.min(c, d)
        val diff = second - first
        if (diff< 0) 0 else diff
    }
}