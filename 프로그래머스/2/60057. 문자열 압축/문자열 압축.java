import java.util.*;
class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        
        for (int i = 1; i <= n / 2; i++) {
            String pre = s.substring(0, i);
            int len = 0;
            if (n % i != 0) len += n % i; 
            int cnt = 1;
            for (int j = i; j < (n / i) * i; j += i) {
                String now = s.substring(j, j + i);
                if (now.equals(pre)) cnt++;
                else {
                    if (cnt != 1) {
                        len += String.valueOf(cnt).length();
                    }
                    len += i;
                    cnt = 1;
                    pre = now;
                }
            }
            if (cnt != 1) len += String.valueOf(cnt).length();
            len += i;
            answer = Math.min(answer, len);
            
        }
        
        //System.out.print(s.substring(0, 1));
        
        return answer;
    }
}