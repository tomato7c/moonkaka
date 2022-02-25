object Solution {
    // a + bi   c + di
    def complexNumberMultiply(num1: String, num2: String): String = {
        val s"${a}+${b}i" = num1; val s"${c}+${d}i" = num2
        val x = a.toInt * c.toInt - b.toInt * d.toInt
        val y = a.toInt * d.toInt + b.toInt * c.toInt
        s"$x+${y}i"
    }
}