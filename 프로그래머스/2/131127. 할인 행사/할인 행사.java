import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        HashMap<String, Integer> now = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            now.put(discount[i], now.getOrDefault(discount[i], 0) + 1);
        }
        
        for (int i = 9; i < discount.length; i++) {
            now.put(discount[i], now.getOrDefault(discount[i], 0) + 1);
            boolean flag = true;
            for (String key : wantMap.keySet()) {
                if (now.containsKey(key) && now.get(key) == wantMap.get(key)) continue;
                else {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
            now.put(discount[i - 9], now.getOrDefault(discount[i - 9], 0) - 1);
        }
        
        return answer;
    }
}