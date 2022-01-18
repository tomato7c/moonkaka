object Solution {
    // 简单模拟
    def isHappy_v1(_n: Int): Boolean = {
        var n = _n
        val set = collection.mutable.Set[Int]()
        while (true) {
            if (set.contains(n)) return false
            set += n
            n = squares(n)
            if (n == 1) return true
        }
        false
    }
    // 判断环的话，类比快慢指针链表中找环
    def isHappy_v2(n: Int): Boolean = {
        var slow = n; var fast = n
        while (true) {
            slow = squares(slow)
            fast = squares(squares(fast))
            if (slow == 1) return true
            if (slow == fast) return false
        }
        false
    }

    private def squares(_n: Int): Int = {
        var res = 0; var n = _n
        while (n > 0) {
            val remain = n % 10
            res += remain * remain
            n /= 10
        }
        res
    }
}