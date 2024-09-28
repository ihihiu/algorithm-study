import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> sh = new HashMap<>();
        for (String key : participant) {
            sh.put(key, sh.getOrDefault(key, 0) + 1);
        }
        for (String key : completion) {
            sh.put(key, sh.get(key) - 1);
            if (sh.get(key) == 0) sh.remove(key);
        }
        for (String key : sh.keySet()) {
            answer = key;
        }
        return answer;
    }
}