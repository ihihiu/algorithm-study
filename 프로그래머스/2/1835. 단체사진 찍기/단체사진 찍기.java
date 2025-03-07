import java.util.*;
class Solution {
    static int answer;
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] ch;
    
    public int getDiff(char a, char b, String tmp) {
        // int ai = 0, bi = 0;
        // for (int i = 0; i < 8; i++) {
        //     if (tmp.charAt(i) == a) ai = i;
        //     if (tmp.charAt(i) == b) bi = i;
        // }
        int ai = tmp.indexOf(a);
        int bi = tmp.indexOf(b);
        return Math.abs(ai - bi) - 1;
    }
    
    public void dfs(int depth, String tmp, String[] data) {
        if (depth == 8) {
            boolean flag = true;
            for (String x : data) {
                char a = x.charAt(0);
                char b = x.charAt(2);
                char op = x.charAt(3);
                int distance = x.charAt(4) - '0';
                int diff = getDiff(a, b, tmp);
                if ((op == '=' && diff != distance) || 
                   (op == '<' && diff >= distance) || 
                   (op == '>' && diff <= distance)) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!ch[i]) {
                ch[i] = true;
                dfs(depth + 1, tmp + friends[i], data);
                ch[i] = false;
            }
        }
        
    }
    
    public int solution(int n, String[] data) {
        answer = 0;
        ch = new boolean[8];
        
        dfs(0, "", data);
        
        return answer;
    }
}