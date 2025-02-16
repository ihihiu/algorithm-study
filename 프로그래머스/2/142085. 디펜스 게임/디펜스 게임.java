import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int lt = 0, sum = 0, cnt = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        for (int rt = 0; rt < enemy.length; rt++) {
            sum += enemy[rt];
            pQ.offer(enemy[rt]);
            if (sum > n) {
                if (cnt == k) return rt;
                cnt++;
                sum -= pQ.poll();      
            } 
        }
        
        return enemy.length;
    }
}