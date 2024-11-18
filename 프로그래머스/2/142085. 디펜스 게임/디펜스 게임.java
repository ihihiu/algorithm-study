import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int len = enemy.length;
        int sum = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < len; i++) {
            sum += enemy[i];
            pQ.offer(enemy[i]);
            while (!pQ.isEmpty() && sum > n) {
                int x = pQ.poll();
                sum -= x;
                k--;
                if (k < 0) return i;
            }
        }
        return len;
    }
}