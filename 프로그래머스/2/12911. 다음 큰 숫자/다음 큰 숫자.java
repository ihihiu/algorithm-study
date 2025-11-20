import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int cnt = 0;
        int num = n;
        while (num / 2 != 0) {
            if (num % 2 == 1) cnt++;
            num /= 2;
        }
        
        while (true) {
            num = answer;
            int c = 0;
            while (num / 2 != 0) {
                if (num % 2 == 1) c++;
                num /= 2;
            }
            if (c == cnt) break;
            answer++;
        }
        return answer;
    }
}