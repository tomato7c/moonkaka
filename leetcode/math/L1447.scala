object Solution {
    def simplifiedFractions(n: Int): List[String] = {
        def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
        val res = collection.mutable.ListBuffer[String]()
        for (b <- 2 to n; a <- 1 until b if gcd(a, b) == 1) res += s"$a/$b"
        res.toList 
    }
}