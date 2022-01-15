class L382(_head: ListNode) {
    // 蓄水池采样
    def getRandom(): Int = {
        var res = -1
        var cur = _head
        var count = 0
        while (cur != null) {
            count += 1
            if (scala.util.Random.nextInt(count) == 0) res = cur.x
            cur = cur.next
        }
        res
    }
}