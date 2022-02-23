import collection.mutable
import scala.util.Random
class RandomizedCollection() {

    private val map = mutable.Map[Int, mutable.Set[Int]]()
    private val list = mutable.ListBuffer[Int]()

    def insert(value: Int): Boolean = {
        list += value
        var set: mutable.Set[Int] = null
        if (map.contains(value)) {
            set = map(value)
        } else {
            set = mutable.Set[Int]()
            map += (value -> set)
        }
        set += list.size - 1
        set.size == 1
    }

    def remove(value: Int): Boolean = {
        if (!map.contains(value) || map(value).isEmpty) return false
        val set = map(value)
        val delIndex = set.iterator.next
        set -= delIndex // 放到这里是为了避免 last值是value的这种奇葩case
        if (delIndex != list.size - 1) { // 避免list只有一个元素
            val set2 = map(list.last)
            set2.remove(list.size - 1)
            set2 += delIndex
            list(delIndex) = list.last
        }
        list.remove(list.size - 1)
        true
    }

    private def swapToLast(del: Int) {
        val last = list.size - 1
        val temp = list(del)
        list(del) = list(last)
        list(last) = temp
    }

    def getRandom(): Int = {
        list(Random.nextInt(list.size))
    }

}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * var obj = new RandomizedCollection()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */