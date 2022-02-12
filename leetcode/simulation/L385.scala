object Solution {
    def deserialize(s: String): NestedInteger = {
        var index = 0
        // return the next token type
        // [ => list
        // ] => end of a list
        // String => a number
        def nextType(): String = {
            def hasNext(): Boolean = index < s.length
            s(index) match {
                case '[' => index += 1; "["
                case ']' => index += 1; "]"
                case ',' => index += 1; nextType()
                case c => {
                    val start = index
                    if (c == '-') index += 1
                    while (hasNext() && s(index).isDigit) index += 1
                    s.substring(start, index)
                }
            }
        }

        def parseList(): NestedInteger = {
            val list = collection.mutable.ListBuffer[NestedInteger]()
            // originally use 'type' to name this variable, but 'type' is a keyword in scala:(
            var ntype = nextType()
            while (ntype != "]") { // != is extend from AnyRef and is same to Object#equals in java
                list += parse(ntype)
                ntype = nextType()
            }
            val res = new NestedInteger
            for (it <- list) res.add(it)
            res
        }

        def parseOne(num: String): NestedInteger = {
            val res = new NestedInteger
            res.setInteger(num.toInt)
            res
        }
        // give a type, parse to a "list" or "single" NestedInteger
        def parse(ntype: String): NestedInteger = {
            ntype match {
                case "[" => parseList()
                case num => parseOne(num)
            }
        }

        parse(nextType())
    }
}