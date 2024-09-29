import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> Q = new LinkedList<>();
        int start = 0, sum = 0, cnt = 0;
        for (int x : truck_weights) {
            sum += x;
            if (sum <= weight && cnt < bridge_length) {
                start++;
                while(!Q.isEmpty() && Q.peek()[1] <= start) {
                    sum -= Q.poll()[0];
                    cnt--;
                }
            } 
            else {
                while (sum > weight || cnt >= bridge_length) {
                    int[] tmp = Q.poll();
                    sum -= tmp[0];
                    start = tmp[1];
                    cnt--;
                }
            }
            Q.offer(new int[]{x, start + bridge_length});
            cnt++;
        }
        int answer = 0;
        while (!Q.isEmpty()) {
            answer = Q.poll()[1];
        }
        
        return answer;
    }
}