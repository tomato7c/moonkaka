object L54 {
    
    val vectors = Array[(Int, Int)]((0, 1), (-1, 0), (-0, -1), (1, 0))
    // 1 2 3
    // 4 5 6
    // 7 8 9
    // 借助向量模拟
    def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
        val res = collection.mutable.ListBuffer[Int]()
        var x = 0
        var y = -1
        val length = matrix.length 
        val width = matrix(0).length
        var vIndex = 0

        val visited: Array[Array[Boolean]] = Array.ofDim(length, width)

        while (res.size < length * width) {
            vIndex %= 4
            val vector = vectors(vIndex)
            var a = x + vector._1
            var b = y + vector._2 
            while (a >= 0 && a < length && b >= 0 && b < width && !visited(a)(b)) {
                x = a
                y = b
                visited(x)(y) = true
                res += matrix(x)(y)
                a += vector._1
                b += vector._2
            }

            vIndex += 1
        }
        res.toList
    }
}