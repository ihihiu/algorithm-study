import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int n = targets.length;
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        int idx = 0;
        while (idx < n){
            answer++;
            int end = targets[idx][1];
            idx++;
            while (idx < n && targets[idx][0] < end){
                if (targets[idx][1] < end) {
                    end = targets[idx][1];
                }
                idx++;
            }
        }
        
        return answer;
    }
}