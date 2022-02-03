object Solution {
    def countGoodRectangles(rectangles: Array[Array[Int]]): Int = {
        val map = rectangles.map(it => it.head min it.last)
        val max = map.max
        map.count(_ == max)
    }
}