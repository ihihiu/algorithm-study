import java.util.*;
class Solution {
    static boolean[] ch;
    static int answer;
    
    static public void dfs(int depth, String now, String target, String[] words) {
        if (depth >= answer) return;
        if (now.equals(target)) {
            answer = depth;
            return;
        }
        else {
            for (int i = 0; i < words.length; i++) {
                if (!ch[i]) {
                    int cnt = 0;
                    for (int j = 0; j < target.length(); j++) {
                        if (words[i].charAt(j) != now.charAt(j)) cnt++; 
                    }
                    if (cnt == 1) {
                        ch[i] = true;
                        dfs(depth + 1, words[i], target, words);
                        ch[i] = false;
                    }
                }
            }
        }
        
    }
    
    public int solution(String begin, String target, String[] words) {
        answer = 100;
        ch = new boolean[words.length];
        dfs(0, begin, target, words);
        return answer == 100 ? 0 : answer;
    }
}