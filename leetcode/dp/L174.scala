object L174 {
    // 问什么设置什么！
    // f(i,j)表示从所有从(i,j)走到终点的路径集合；属性为最小值
    // 根据最后一步向上/下走可以分为两类
    // f(i,j) + arr(i)(j) = f(i + 1)(j);  f(i)(j) + arr(i)(j) = f(i)(j + 1)
    def calculateMinimumHP(arr: Array[Array[Int]]): Int = {
        val m = arr.length; val n = arr(0).length
        val f: Array[Array[Int]] = Array.ofDim(m, n)
        f(m - 1)(n - 1) = if (arr(m - 1)(n - 1) >= 0) 1 else -arr(m - 1)(n - 1) + 1

        // 初始化最后一列
        for (i <- (0 until m - 1).reverse) {
            var down = f(i + 1)(n - 1) - arr(i)(n - 1)
            down = if (down <= 0) 1 else down
            f(i)(n - 1) = down
        }

        // 初始化最后一行
        for (j <- (0 until n - 1).reverse) {
            var right = f(m - 1)(j + 1) - arr(m - 1)(j)
            right = if (right <= 0) 1 else right
            f(m - 1)(j) = right
        }

        for (i <- (0 until m - 1).reverse; j <- (0 until n - 1).reverse) {
            var down = f(i + 1)(j) - arr(i)(j)
            down = if (down <= 0) 1 else down
            var right = f(i)(j + 1) - arr(i)(j)
            right = if (right <= 0) 1 else right
            f(i)(j) = Math.min(down, right)
        }
        f(0)(0)
    }
}