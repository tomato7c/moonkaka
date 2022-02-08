import scala.collection.mutable
import scala.util.Random
// 插入/删除借助哈希表, 获取随机数用数组
// 删除时将数字交换到数组最后一个位置来删除
class RandomizedSet() {
    // value -> index in list
    val map = mutable.Map[Int, Int]()
    val list = mutable.ListBuffer[Int]()

    def insert(value: Int): Boolean = {
        if (map.contains(value)) {
            false
        } else {
            list += value
            map += (value -> (list.length - 1))
            true
        }
    }

    def remove(value: Int): Boolean = {
        if (!map.contains(value)) {
            false
        } else {
            val index = map(value)
            if (index != list.length - 1) {
                list(index) = list.last
                map(list(index)) = index
            }

            map.remove(value)
            list.remove(list.length - 1)
            true
        }
    }

    def getRandom(): Int = {
        val randomIdx = Random.nextInt(list.length)
        list(randomIdx)
    }

    private def swap(a: Int, b: Int) {
        val temp = list(a)
        list(a) = list(b)
        list(b) = temp
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */