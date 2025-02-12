import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        int idx = 0, start = -1, end = -1;
        
        while (idx < targets.length) {
            int[] now = targets[idx];
            if (now[0] >= end) {
                answer++;
                start = now[0];
                end = now[1];
            }
            else {
                if (now[0] < start) start = now[0];
            }
            idx++;
        }
        return answer;
    }
}