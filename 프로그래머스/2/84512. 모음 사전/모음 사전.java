import java.util.*;
class Solution {
    static char[] list = {'A', 'E', 'I', 'O', 'U'};
    static int answer;
    static boolean found;
    static String target;
    public int solution(String word) {
        answer = 0;
        found = false;
        target = word;
        dfs(0, "");
        return answer;
    }
    
    static void dfs(int depth, String tmp) {
        if (tmp.equals(target)) {
            found = true;
            return;
        }
        if (depth >= 5) return;
        for (int i = 0; i < 5; i++) {
            if (found) return;
            answer++;
            dfs(depth + 1, tmp + list[i]);
        }
    }
}