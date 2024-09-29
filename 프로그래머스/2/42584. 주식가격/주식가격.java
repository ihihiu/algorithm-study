import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            int price = prices[i];
            while (!pQ.isEmpty() && pQ.peek()[0] > price) {
                int[] tmp = pQ.poll();
                answer[tmp[1]] = i - tmp[1];
            }
            pQ.offer(new int[]{price, i});
        }
        while(!pQ.isEmpty()) {
            int[] tmp = pQ.poll();
            answer[tmp[1]] = n - 1 - tmp[1];
        }
        return answer;
    }
}