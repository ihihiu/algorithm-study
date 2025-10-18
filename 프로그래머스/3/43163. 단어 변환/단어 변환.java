import java.util.*;
class Solution {
    static int N, answer;
    static boolean[] ch;
    public int solution(String begin, String target, String[] words) {
        answer = 100;
        N = words.length;
        ch = new boolean[N];
        
        dfs(0, begin, words, target);
        
        return answer == 100 ? 0 : answer;
    }
    
    static public void dfs(int depth, String now, String[] words, String target) {
        if (now.equals(target)) {
            answer = Math.min(answer, depth);
        }
        if (depth == N) return;
        for (int i = 0; i < N; i++) {
            if (!ch[i] && calculate(words[i], now)) {
                ch[i] = true;
                dfs(depth + 1, words[i], words, target);
                ch[i] = false;
            }
        }
    }
    
    public static boolean calculate(String now, String target) {
        int cnt = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != target.charAt(i)) {
                cnt++;
                if (cnt > 1) return false;
            }
        }
        return cnt == 1 ? true : false;
    }
}