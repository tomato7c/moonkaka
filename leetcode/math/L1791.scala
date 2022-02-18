object Solution {
    def findCenter(edges: Array[Array[Int]]): Int = {
        val a = edges(0)(0); val b = edges(0)(1)
        if (edges(1)(0) == a || edges(1)(1) == a) a else b
    }
}