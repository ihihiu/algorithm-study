import java.util.*;
class Solution {
    public void dfs(int depth, int start, int x, String str, HashMap<String, Integer> sh, String tmp) {
        if (depth == x) {
            sh.put(tmp, sh.getOrDefault(tmp, 0) + 1);
        }
        else {
            for (int i = start; i < str.length(); i++) {
                dfs(depth + 1, i + 1, x,  str, sh, tmp + str.charAt(i));
            }
        }
    }
    
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for (int x : course) {
            HashMap<String, Integer> sh = new HashMap<>();
            for (String y : orders) {
                if (y.length() < x) continue;
                char[] s = y.toCharArray();
                Arrays.sort(s);
                String str = "";
                for (char c : s) str += c;
                dfs(0, 0, x, str, sh, "");
            }
            ArrayList<Integer> cnt = new ArrayList<>(sh.values());
            int max = 0;
            for (int c : cnt) {
                max = Math.max(max, c);
            }

            if (max >= 2) {
                for (String key : sh.keySet()) {
                    if (sh.get(key) == max) answer.add(key);
                }
            }
        }
        
        Collections.sort(answer, (a, b) -> a.compareTo(b));
        return answer;
    }
}