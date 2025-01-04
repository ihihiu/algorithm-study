import java.util.*;
class Solution {
    static int answer;
    static int cnt;
    static boolean flag;
    static String[] alpha = {"A", "E", "I", "O", "U"};
    static public void dfs(int depth, String tmp, String word) {
        if (tmp.equals(word)) {
            answer = cnt;
            return;
        }
        if (depth == 5) return;
        else {
            for (int i = 0; i < 5; i++) {
                cnt++;
                dfs(depth + 1, tmp + alpha[i], word);
            }
        }
    }
    public int solution(String word) {
        answer = 0;
        flag = false;
        dfs(0, "", word);
        return answer;
    }
}