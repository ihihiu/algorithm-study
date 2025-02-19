import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {

        int n = queue1.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < n; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        if ((sum1 + sum2) % 2 == 1) return -1;
        if (sum1 == sum2) return 0;
        
        for (int i = 1; i <= 4 * n; i++) {
            if (sum1 > sum2) {
                int now = q1.poll();
                q2.offer(now);
                sum1 -= now;
                sum2 += now;
            }
            else {
                int now = q2.poll();
                q1.offer(now);
                sum2 -= now;
                sum1 += now;
            }
            
            if (sum1 == sum2) return i;
        }
        
        return -1;
    }
}