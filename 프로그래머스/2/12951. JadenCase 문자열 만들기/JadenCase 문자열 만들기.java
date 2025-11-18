import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        if (Character.isAlphabetic(s.charAt(0))) {
            answer += Character.toUpperCase(s.charAt(0));
        } else answer += s.charAt(0);
        
        for (int i = 1; i < s.length(); i++) {
            if (answer.charAt(i - 1) == ' ') {
                answer += Character.toUpperCase(s.charAt(i));
            } else {
                answer += Character.toLowerCase(s.charAt(i));
            }
        }
        return answer;
    }
}