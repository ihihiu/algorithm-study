import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> sh = new HashMap<>();
        for (int x : tangerine) {
            sh.put(x, sh.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        for (int key : sh.keySet()) {
            pQ.offer(sh.get(key));
        }
        while (!pQ.isEmpty() && k > 0) {
            answer++;
            k -= pQ.poll();
        }
        
        return answer;
    }
}