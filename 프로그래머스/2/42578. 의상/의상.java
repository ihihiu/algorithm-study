import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> sh = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            sh.put(clothes[i][1], sh.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        
        for (int x : sh.values()) {
            answer *= (x + 1);
        }
        
        return answer - 1;
    }
}