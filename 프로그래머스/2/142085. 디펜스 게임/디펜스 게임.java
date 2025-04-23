import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pQ.offer(enemy[i]);
            if (n < 0 && k > 0) {
                n += pQ.poll();
                k--;
            }
            if (n < 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}