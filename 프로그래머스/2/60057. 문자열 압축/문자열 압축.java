import java.util.*;
class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        for (int i = n / 2; i >= 1; i--) {
            int total = 0;
            String pre = s.substring(0, i);
            int cnt = 1;
            for (int j = i; j + i <= n; j += i) {
                if (pre.equals(s.substring(j, j + i))) cnt++;
                else {
                    if (cnt != 1) total += String.valueOf(cnt).length(); 
                    total += i;
                    pre = s.substring(j, j + i);
                    cnt = 1;
                    if (total > answer) break;
                }
            }
            total += i;
            if (cnt != 1) total += String.valueOf(cnt).length(); 
            total += (n % i);
            answer = Math.min(answer, total);
            
        }
        return answer;
    }
}