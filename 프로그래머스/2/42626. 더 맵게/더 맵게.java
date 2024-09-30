import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int x : scoville) pQ.offer(x);
        while (pQ.peek() < K) {
            if (pQ.size() < 2) return -1;
            pQ.offer(pQ.poll() + 2 * pQ.poll());
            answer++;
        }

        return answer;
    }
}