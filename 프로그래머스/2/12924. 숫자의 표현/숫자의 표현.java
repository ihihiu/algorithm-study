import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int lt = 0;
        int sum = 0;
        for (int rt = 1; rt <= n; rt++) {
            sum += rt;
            if (sum == n) answer++;
            while (lt <= rt && sum > n) {
                sum -= lt;
                lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}