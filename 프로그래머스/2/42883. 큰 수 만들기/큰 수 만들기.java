import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int n = number.length();
        for (int i = k - 1; i >= 0; i--) {
            int now = sb.charAt(i) - '0';
            int post = sb.charAt(i + 1) - '0';
            if (now < post) sb.deleteCharAt(i);
            else {
                for (int j = i + 1; j < n - 1; j++) {
                    if (sb.charAt(j) - '0' < sb.charAt(j + 1) - '0') {
                        sb.deleteCharAt(j);
                        break;
                    }
                }
            }
        }
        
        String answer = sb.substring(0, number.length() - k);
        return answer;
    }
}