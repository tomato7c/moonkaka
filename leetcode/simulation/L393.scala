object Solution {
    // 0
    // 11   10
    // 111  10  10
    // 1111 10  10  10
    def validUtf8(data: Array[Int]): Boolean = {
        var i = 0
        def validByteCount(): Int = {
            val cur = data(i)
            if (getBitAt(cur, 7) == 0) return 1
            var countOne = 0
            while (countOne <= 4 && getBitAt(cur, 7 - countOne) == 1) countOne += 1
            if (countOne < 2 || countOne > 4) return -1
            // k in [2, 4]
            for (index <- 2 to countOne) {
                val offset = i + index - 1
                if (offset >= data.length) return -1
                if (getBitAt(data(offset), 7) != 1 || getBitAt(data(offset), 6) != 0) return -1
            }
            countOne
        }
        while (i < data.length) {
            val byteCount = validByteCount()
            byteCount match {
                case 1 => i += 1
                case 2 => i += 2
                case 3 => i += 3
                case 4 => i += 4
                case _ => return false
            }
        }
        true
    }

    private def getBitAt(num: Int, index: Int): Int = (num >> index) & 1
}