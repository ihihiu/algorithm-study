import java.util.*;
class Solution {
    static int n;
    static int answer = -1;
    static int[] ch;
     
    
    public void dfs(int depth, int k, int[][] dungeons) {
        if (depth == n) return;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                if (k >= dungeons[i][0]) {
                    ch[i] = 1;
                    answer = Math.max(answer, depth + 1);
                    dfs(depth + 1, k - dungeons[i][1], dungeons);
                    ch[i] = 0;
                }
            }
        }
        
    }
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        ch = new int[n];
        dfs(0, k, dungeons);
        return answer;
    }
}