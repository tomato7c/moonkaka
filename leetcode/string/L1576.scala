object L1576 {
    def modifyString(_s: String): String = {
        val s = _s.toCharArray
        for (i <- s.indices if s(i) == '?') {
            val before = safeIndex(s, i - 1)
            val after = safeIndex(s, i + 1)
            var c = 'a'
            while (c == before || c == after) c = (c + 1).toChar
            s(i) = c
        }
        new String(s)
    }

    private def safeIndex(s: Array[Char], index: Int): Char = if (index < 0 || index >= s.length) ' ' else s(index)
}