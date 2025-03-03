import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            int nowPrice = prices[i];
            while (!pQ.isEmpty() && pQ.peek()[0] > nowPrice) {
                int[] now = pQ.poll();
                answer[now[1]] = i - now[1];
            }
            pQ.offer(new int[]{nowPrice, i});
        }
        while (!pQ.isEmpty()) {
            int[] now = pQ.poll();
            answer[now[1]] = n - 1 - now[1];
        }
        
        return answer;
    }
}