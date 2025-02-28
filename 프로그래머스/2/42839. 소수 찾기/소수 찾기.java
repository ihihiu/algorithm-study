import java.util.*;
class Solution {
    static HashSet<Integer> set = new HashSet<Integer>();
    static int[] ch;
    
    public void dfs(int depth, String tmp, String numbers) {
        if (depth > numbers.length()) return;
        else {
            for (int i = 0; i < numbers.length(); i++){
                if (ch[i] == 0) {
                    ch[i] = 1;
                    set.add(Integer.valueOf(tmp + numbers.charAt(i)));
                    dfs(depth + 1, tmp + numbers.charAt(i), numbers);
                    ch[i] = 0;
                }
            }
        }
        
    }
    
    public int solution(String numbers) {
        int answer = 0;
        ch = new int[numbers.length()];
        dfs(0, "", numbers);
        for (int x : set) {
            if (x == 0 || x == 1) continue;
            boolean flag = true;
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}