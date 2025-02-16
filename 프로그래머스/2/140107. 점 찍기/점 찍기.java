import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (long i = 0; i <= d; i += k) {
            int j = (int) Math.sqrt((long) d * d - i * i);
            answer += (j / k) + 1;
        }
        return answer;
    }
}