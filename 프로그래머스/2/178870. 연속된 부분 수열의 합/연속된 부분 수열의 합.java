import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int n = sequence.length, lt = 0, sum = 0;
        int cnt = Integer.MAX_VALUE;
        for (int rt = 0; rt < n; rt++){
            sum += sequence[rt];
            while (sum > k) {
                sum -= sequence[lt];
                lt++;
            }
            if (sum == k) {
                if (lt == rt) {
                    return new int[]{lt, rt};
                }
                else if (cnt > rt - lt) {
                    answer[0] = lt;
                    answer[1] = rt;
                    cnt = rt - lt;
                }
            }
        }
        
        return answer;
    }
}