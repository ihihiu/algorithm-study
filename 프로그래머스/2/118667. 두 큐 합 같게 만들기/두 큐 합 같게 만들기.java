import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        long sum1 = Arrays.stream(queue1).asLongStream().sum();
        long sum2 = Arrays.stream(queue2).asLongStream().sum();
        
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        if ((sum1 + sum2) % 2 != 0) return -1;
        
        for (int i = 0; i < queue1.length * 3; i++) {
            if (sum1 == sum2) return i;
            else if (sum1 > sum2) {
                int x = q1.poll();
                q2.offer(x);
                sum1 -= x;
                sum2 += x;
            }
            else {
                int x = q2.poll();
                q1.offer(x);
                sum1 += x;
                sum2 -= x;
            }
        }
        
        return answer;
    }
}