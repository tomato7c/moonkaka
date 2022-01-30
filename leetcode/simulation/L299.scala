object Solution {
    // hash统计
    def getHint(secret: String, guess: String): String = {
        var bulls, cows = 0
        val secretMap = collection.mutable.Map[Char, Int]()
        val tempGuess = guess.toArray
        for (i <- secret.indices) {
            if (secret(i) == guess(i)) {
                tempGuess(i) = '*'
                bulls += 1
            } else {
                secretMap += (secret(i) -> (secretMap.getOrElse(secret(i), 0) + 1))
            }
        }
        // 统计cows
        for (c <- tempGuess if c != '*') {
            val newValue = secretMap.getOrElse(c, 0) - 1
            secretMap += (c -> newValue)
            if (newValue >= 0) cows += 1
        }
        s"${bulls}A${cows}B"
    }
}