import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase();
        
        for (int i = 0; i < new_id.length(); i++) {
            char now = new_id.charAt(i);
            if (Character.isAlphabetic(now) || Character.isDigit(now) || now == '-' || now == '_' || now == '.') answer += now;
        }
        
        while(answer.contains("..")) answer = answer.replace("..", ".");
        if (answer.charAt(0) == '.') answer = answer.substring(1);
        
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') answer = answer.substring(0, answer.length() - 1);
        
        if (answer.length() == 0) answer = "a";
        
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        
        while (answer.length() < 3) {
            answer += String.valueOf(answer.charAt(answer.length() - 1));
        }        
        
        
        return answer;
    }
}