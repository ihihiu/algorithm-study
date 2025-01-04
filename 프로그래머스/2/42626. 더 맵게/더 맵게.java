import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> a - b);
        for (int x : scoville) pQ.add(x);
        if (pQ.peek() >= K) return 0;
        for (int i = 0; i < scoville.length - 1; i++) {
            int sco = pQ.poll() + 2 * pQ.poll();
            if (sco >= K) {
                if (pQ.isEmpty() || (!pQ.isEmpty() && pQ.peek() >= K)) {
                    answer = i + 1;
                    break;    
                }
            }
            pQ.offer(sco);
        }
        return answer;
    }
}