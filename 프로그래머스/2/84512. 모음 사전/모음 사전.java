import java.util.*;
class Solution {
    static int answer, cnt;
    static String target;
    static char[] aeiou = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        answer = 0;
        cnt = 0;
        target = word;
        dfs(0, "");
        
        return answer;
    }
    
    static public void dfs(int depth, String tmp) {
        if (answer != 0) return;
        if (tmp.equals(target)) {
            answer = cnt;
            return;
        }
        if (depth == aeiou.length) return;
        for (int i = 0; i < aeiou.length; i++) {
            cnt++;
            dfs(depth + 1, tmp + aeiou[i]);
        }
    }
}