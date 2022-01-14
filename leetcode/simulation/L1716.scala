object L1716 {
    def totalMoney(n: Int): Int = {
        var monday = 1
        var cur = 1
        var total = 0
        var today = 1
        while (today <= n) {
            total += cur
            if (today % 7 == 0) {
                cur = monday + 1
                monday = cur
            } else {
                cur += 1
            }
            today += 1
        }
        total
    }
}