import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        
        while (!s.equals("1")) {
            answer[0]++;
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') cnt++;
                else answer[1]++;
            }
            String tmp = "";
            while (cnt != 0) {
                tmp = String.valueOf(cnt % 2) + tmp;
                cnt /= 2;
            }
            s = tmp;
        }
        return answer;
    }
}