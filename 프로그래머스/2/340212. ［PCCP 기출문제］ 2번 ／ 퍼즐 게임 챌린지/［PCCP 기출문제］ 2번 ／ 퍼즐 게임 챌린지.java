import java.util.*;
class Solution {
    
    public boolean isOkay(int[] diffs, int[] times, long limit, int mid) {
        int pre = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= mid) limit -= times[i];
            else {
                limit -= (times[i] + pre) * (diffs[i] - mid) + times[i];
            }
            pre = times[i];
            if (limit < 0) return false;
        }
        return true;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int start = Arrays.stream(diffs).min().getAsInt();
        int end = Arrays.stream(diffs).max().getAsInt();
        while(start <= end) {
            int mid = (start + end) / 2;
            if (isOkay(diffs, times, limit, mid)) {
                answer = Math.min(mid, answer);
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return answer;
    }
}