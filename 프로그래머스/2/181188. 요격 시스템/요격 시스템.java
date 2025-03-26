import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        int start = 0, end = 100000000;
        for (int[] x : targets) {
            int s = x[0];
            int e = x[1];
            if (s < end) {
                start = Math.max(start, s);
                end = Math.min(end, e);
            }
            else {
                answer++;
                start = s;
                end = e;
            }
        }
        return answer;
    }
}