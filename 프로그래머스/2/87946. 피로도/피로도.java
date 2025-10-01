import java.util.*;
class Solution {
    static int answer;
    static boolean[] ch;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        ch = new boolean[dungeons.length];
        dfs(0, dungeons, k);
        return answer;
    }
    
    public void dfs(int depth, int[][] dungeons, int k) {
        if (depth == dungeons.length) {
            return;
        }
        else {
            for (int i = 0; i < dungeons.length; i++) {
                if (ch[i] == false && k >= dungeons[i][0]) {
                    answer = Math.max(answer, depth + 1);
                    ch[i] = true;
                    dfs (depth + 1, dungeons, k - dungeons[i][1]);
                    ch[i] = false;
                }
            }
        }
    }
}