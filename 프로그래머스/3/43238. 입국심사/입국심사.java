import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long lt = 1, rt = (long) times[times.length - 1] * n;
        long answer = rt;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            
            long num = 0;
            
            for (int time: times) {
                num += mid / time;
            }
            
            if (num >= n) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
            
        }
        return answer;
    }
    
}