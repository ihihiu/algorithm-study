import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, HashSet<String>> sh = new HashMap<>();
        
        for (String[] cloth : clothes) {
            if (!sh.containsKey(cloth[1])) {
                sh.put(cloth[1], new HashSet<>());
            }
            sh.get(cloth[1]).add(cloth[0]);
        }
        
        for (String key : sh.keySet()) {
            answer *= (sh.get(key).size() + 1);
        }
        
        return answer - 1;
    }
}