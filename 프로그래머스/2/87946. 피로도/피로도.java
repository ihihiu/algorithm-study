import java.util.*;
class Solution {
    static int n, answer;
    static int[] ch;
    
    public void dfs(int depth, int[][] dungeons, int now) {
        if (depth > answer) answer = Math.max(answer, depth);
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0 && now >= dungeons[i][0]) {
                ch[i] = 1;
                dfs(depth + 1, dungeons, now - dungeons[i][1]);
                ch[i] = 0;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        n = dungeons.length;
        ch = new int[n];
        dfs(0, dungeons, k);
        return answer;
    }
}