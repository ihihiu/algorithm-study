import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int n = attacks.length;
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] attack : attacks) {
            pQ.offer(attack);
        }
        int time = 0, nowHealth = health, cnt = 0;
        while (!pQ.isEmpty()) {
            time++;
            if (pQ.peek()[0] != time) {
                cnt++;
                if (cnt == bandage[0]) {
                    nowHealth += bandage[2];
                    cnt = 0;
                }
                nowHealth += bandage[1];
                if (nowHealth > health) nowHealth = health;
            }
            else{
                int[] now = pQ.poll();
                nowHealth -= now[1];
                cnt = 0;
            }
            if (nowHealth <= 0) return -1;
        }
        
        if (nowHealth <= 0) return -1;
        return nowHealth;
    }
}