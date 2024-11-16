import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Long, Long> sh = new HashMap<>();
        TreeSet<Long> set = new TreeSet<>();
        for (long x : weights) {
            sh.put(x, sh.getOrDefault(x, 0L) + 1);
            set.add(x);
        }
        for (long x : set) {
            long cnt = sh.get(x);
            if (cnt > 1) answer += (cnt * (cnt - 1) / 2);
            if (sh.containsKey(2 * x)){
                answer += cnt * (sh.get(2 * x));
            }
            if (sh.containsKey(3 * x / 2) && (3 * x) % 2 == 0){
                answer += cnt * (sh.get(3 * x / 2));
            }
            if (sh.containsKey(4 * x / 3) && (4 * x) % 3 == 0){
                answer += cnt * (sh.get(4 * x / 3));
            }
        }
        
        return answer;
    }
}