object L1332 {
    // 脑筋急转弯...
    def removePalindromeSub(s: String): Int = {
        if (s.reverse.equals(s)) 1 else 2
    }
}