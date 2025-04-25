import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> sh = new HashMap<>();
        for (int x : tangerine) {
            sh.put(x, sh.getOrDefault(x, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(sh.values());
        Collections.sort(list, (a, b) -> b - a);
        
        for (int x : list) {
            if (k <= 0) break;
            k -= x;
            answer++;
        }
        
        return answer;
    }
}