import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Long, Long> sh = new HashMap<>();
        for (long x : weights) {
            sh.put(x, sh.getOrDefault(x, 0L) + 1);
        }
        for (long x : sh.keySet()) {
            long cnt = sh.get(x);
            if (cnt != 1) {
                answer += (cnt * (cnt - 1) / 2);
            }
            if (sh.containsKey(x * 2)) {
                answer += (cnt * sh.get(x * 2));
            }
            if (x % 2 == 0 && sh.containsKey(x * 3 / 2)) {
                answer += (cnt * sh.get(x * 3 / 2));
            }
            if (x % 3 == 0 && sh.containsKey(x * 4 / 3)) {
                answer += (cnt * sh.get(x * 4 / 3));
            }
        }
        return answer;
    }
}