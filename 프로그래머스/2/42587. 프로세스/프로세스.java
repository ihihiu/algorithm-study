import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> Q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            Q.offer(new int[] {priorities[i], i});
        }
        Arrays.sort(priorities);
        
        int idx = priorities.length - 1;
        int max = priorities[idx];
        while (!Q.isEmpty()) {
            int[] now = Q.poll();
            if (now[0] == max) {
                if (now[1] == location) {
                    answer = priorities.length - idx;
                    break;           
                }
                idx--;
                max = priorities[idx];
            }
            else {
                Q.offer(now);
            }
        }
        
        return answer;
    }
}