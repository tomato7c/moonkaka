object L70 {
    // 跟斐波那契数列一样f(i) = f(i - 1) + f(i - 2)
    def climbStairs(n: Int): Int = {
        val f = new Array[Int](n + 1)
        f(0) = 1
        f(1) = 2
        for (i <- 2 to n - 1) f(i) = f(i - 2) + f(i - 1)
        f(n - 1)
    }

    def climbStairsV2(n: Int): Int = {
	    var prepre = 0
	    var pre = 1
	    for (i <- 1 to n) {
	        val now = prepre + pre
	        prepre = pre
	        pre = now
	    }
	    pre
    }

}