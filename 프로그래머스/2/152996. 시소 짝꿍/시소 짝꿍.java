import java.util.*;
class Solution {
    public long solution(int[] weights) {
        int n = weights.length;
        long answer = 0;
        HashMap<Long, Long> sh = new HashMap<>();
        for (long x : weights) {
            sh.put(x, sh.getOrDefault(x, 0L) + 1);
        }
        
        for (long key : sh.keySet()) {
            long cnt = sh.get(key);
            if (key * 3 % 2 == 0 && sh.containsKey(key * 3 / 2)) answer += (cnt * sh.get(key * 3 / 2));
            if (sh.containsKey(key * 2)) answer += (cnt * sh.get(key * 2));
            if (key * 4 % 3 == 0 && sh.containsKey(key * 4 / 3)) answer += (cnt * sh.get(key * 4 / 3));
            if (cnt > 1) answer += (cnt * (cnt - 1) / 2);
        }
        
        return answer;
    }
}