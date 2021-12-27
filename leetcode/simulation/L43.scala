object L43 {
    // 模拟，可以用一个a + b数组存储a * b
    def multiply(num1: String, num2: String): String = {
        val a = new Array[Int](num1.length)
        val b = new Array[Int](num2.length)
        val c = new Array[Int](num1.length + num2.length)
        for (i <- num1.indices.reverse) a(num1.length - i - 1) = num1(i) - '0' // "123" -> 3,2,1
        for (i <- num2.indices.reverse) b(num2.length - i - 1) = num2(i) - '0'
        // 累积每一位上的值
        for (i <- 0 until a.length; j <- 0 until b.length) {
            c(i + j) += a(i) * b(j)
        }
        //处理进位
        var t = 0
        for (i <- c.indices) {
            c(i) += t
            t = c(i) / 10
            c(i) = c(i) % 10
        }

        // 处理末尾0
        var index = c.length - 1
        while (index > 0 && c(index) == 0) index -= 1
        var res = ""
        for (i <- Range(0, index + 1).reverse) res += (c(i) + '0').toChar
        res
    }
}