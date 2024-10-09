import java.util.*;
class Solution {
    int cnt;
    int answer;
    char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    
    public void DFS(int depth, String word, String tmp) {
        if (word.equals(tmp)) answer = cnt;
        if (depth == 5) return;
        for (int i = 0; i < 5; i++) {
            cnt++;
            DFS(depth + 1, word, tmp + alpha[i]);
        }
        
    }
    
    public int solution(String word) {
        answer = 0;
        cnt = 0;
        DFS(0, word, "");
        return answer;
    }
}