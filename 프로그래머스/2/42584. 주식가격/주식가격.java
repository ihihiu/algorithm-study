import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        // (인덱스, 가격)
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        
        for (int i = 0; i < n; i++) {
            while (!pQ.isEmpty() && prices[i] < pQ.peek()[1]) {
                int[] now = pQ.poll();
                answer[now[0]] = i - now[0];
            }
            pQ.offer(new int[]{i, prices[i]});
        }
        
        while (!pQ.isEmpty()) {
            int[] now = pQ.poll();
            answer[now[0]] = n - 1 - now[0];
        }
        
        
        return answer;
    }
}