// 1. TreeMap::floor, TreeSet::ceiling的使用
// 2. 借助虚拟节点(哨兵)通用化逻辑，避免复杂的边界条件判断
// 3. 区间合并5个case: 
//    1.[_, x - 1]x[x + 1, _]
//    2.[_, _]x[_, _]
//    3.[_,x-1]x[_,_]
//    4.[_,_]x[x+1,_]
//    5. in left or in right
import java.util.*;
class SummaryRanges {

    private TreeSet<int[]> set = null;

    public SummaryRanges() {
        set = new TreeSet<>((a, b) -> a[0] - b[0]);
        set.add(new int[] {-2, -2});
        set.add(new int[] {10002, 10002});
    }
    
    public void addNum(int val) {
        var cur = new int[] {val, val};
        var floor = set.floor(cur);
        var ceiling = set.ceiling(cur);
        if (floor[1] == val - 1 && ceiling[0] == val + 1) {
            set.remove(floor);
            set.remove(ceiling);
            set.add(new int[] {floor[0], ceiling[1]});
        } else if (floor[1] < val - 1 && ceiling[0] == val + 1) {
            set.remove(ceiling);
            set.add(new int[] {val, ceiling[1]});
        } else if (floor[1] == val - 1 && ceiling[0] > val + 1) {
            set.remove(floor);
            set.add(new int[] {floor[0], val});
        } else if (floor[1] < val - 1 && ceiling[0] > val + 1) {
            set.add(new int[] {val, val});
        }
    }
    
    public int[][] getIntervals() {
        var size = set.size();
        var res = new int[size - 2][2];
        var it = set.iterator(); it.next();
        for (int i = 0; i < size - 2; i++) {
            res[i] = it.next();
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */