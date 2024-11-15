import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int lt = 0, sum = 0, cnt = 1000000;
        for (int rt = 0; rt < sequence.length; rt++){
            sum += sequence[rt];
            while (sum > k) {
                sum -= sequence[lt];
                lt++;
            }
            if (sum == k && rt - lt < cnt) {
                cnt = rt - lt;
                answer[0] = lt;
                answer[1] = rt;
            }
        }
        return answer;
    }
}