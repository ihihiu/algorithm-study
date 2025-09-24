import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        
        // (가격, 인덱스)
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < N; i++) {
            int now = prices[i];
            while (!pQ.isEmpty() && pQ.peek()[0] > now) {
                int[] x = pQ.poll();
                answer[x[1]] = i - x[1];
            }
            pQ.offer(new int[]{now, i});
        }
        
        while(!pQ.isEmpty()) {
            int[] x = pQ.poll();
            answer[x[1]] = N - x[1] - 1;
        }
        
        return answer;
    }
}