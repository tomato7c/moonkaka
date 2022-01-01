object L67 {
    def addBinary(_a: String, _b: String): String = {
        val res = new StringBuilder()
        val a = _a.reverse
        val b = _b.reverse
        var index, next = 0
        while (index < a.length || index < b.length) {
            val v = indexWithDefaultZero(a, index) + indexWithDefaultZero(b, index) + next
            next = v / 2
            res.append(v % 2)
            index += 1
        }
        if (next != 0) res.append(next)
        res.reverse.toString
    }

    private def indexWithDefaultZero(s: String, index: Int): Int = {
        val c = if (index >= s.length) '0' else s(index)
        c - '0'
    }
}