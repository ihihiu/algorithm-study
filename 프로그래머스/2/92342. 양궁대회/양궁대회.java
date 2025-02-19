import java.util.*;

class Solution {
    static int[] answer = new int[11];
    static int diff = 0;
    
    public void dfs(int depth, int n, int[] info, int[] tmp) {
        if (depth > n) return;
        int apeach = 0, lion = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && tmp[i] == 0) continue;
            if (info[i] >= tmp[i]) apeach += (10 - i);
            else lion += (10 - i);
        }
        if (lion - apeach > diff) {
            for (int i = 0; i < 11; i++) {
                answer[i] = tmp[i];
            }
            if (depth < n) answer[10] += (n - depth);
            diff = lion - apeach;
        }
        else {
            for (int i = 10; i >= 0; i--) {
                if (tmp[i] == 0) {
                    tmp[i] = info[i] + 1;
                    dfs(depth + info[i] + 1, n, info, tmp);
                    tmp[i] = 0;
                }
                
            }
        }
    }
    
    public int[] solution(int n, int[] info) {
        int[] tmp = new int[11];
        dfs(0, n, info, tmp);
        for (int x : answer) if (x != 0) return answer;
        return new int[]{-1};
    }
}