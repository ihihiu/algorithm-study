import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> sh = new HashMap<>();
        for (String[] x : clothes) {
            if (!sh.containsKey(x[1])) sh.put(x[1], new ArrayList<>());
            sh.get(x[1]).add(x[0]);
        }
        int answer = 1;
        for (String key : sh.keySet()) {
            answer *= (sh.get(key).size() + 1);            
        }
        answer--;
        return answer;
    }
}