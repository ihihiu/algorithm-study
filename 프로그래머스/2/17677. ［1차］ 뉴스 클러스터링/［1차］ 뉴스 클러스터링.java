import java.util.*;
class Solution {
    public int solution(String str1, String str2) {        
        int union = 0;
        int intersection = 0;
        
        HashMap<String, Integer> sh1 = new HashMap<>();
        HashMap<String, Integer> sh2 = new HashMap<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String x = str1.substring(i, i + 2);
            if (x.charAt(0) < 'a' || x.charAt(0) > 'z' || x.charAt(1) < 'a' || x.charAt(1) > 'z') continue;
            sh1.put(x, sh1.getOrDefault(x, 0) + 1);
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String x = str2.substring(i, i + 2);
            if (x.charAt(0) < 'a' || x.charAt(0) > 'z' || x.charAt(1) < 'a' || x.charAt(1) > 'z') continue;
            sh2.put(x, sh2.getOrDefault(x, 0) + 1);
        }
        
        for (String a : sh1.keySet()) {
            if (sh2.containsKey(a)) {
                intersection += Math.min(sh1.get(a), sh2.get(a));
                union += Math.max(sh1.get(a), sh2.get(a));
            } else {
                union += sh1.get(a);
            }
            
        }
        
        for (String b : sh2.keySet()) {
            if (!sh1.containsKey(b)) {
                union += sh2.get(b);
            }
        }
        
        if (union == 0) return 65536;
        return intersection * 65536 / union;
    }
}