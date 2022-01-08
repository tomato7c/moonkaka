// simulation
object L1629 {
    // 结果保存字典序最大值，相等时要特判
    def slowestKey(releaseTimes: Array[Int], keysPressed: String): Char = {
        var res = 0
        var slowestIndex = 0
        for (i <- releaseTimes.indices) {
            var dur = -1
            if (i == 0) dur = releaseTimes(i)
            else dur = releaseTimes(i) - releaseTimes(i - 1)

            if (res == dur && keysPressed(slowestIndex) < keysPressed(i)) {
                slowestIndex = i
            } else if (res < dur) {
                res = dur
                slowestIndex = i
            }
        }
        keysPressed(slowestIndex)
    }
}