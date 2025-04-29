import java.util.*;
class Solution {
    static HashMap<Integer, HashMap<String, Integer>> sh;
    
    public static void dfs(int depth, int start, char[] str, int[] course, String tmp) {
        for (int c : course) {
            if (depth == c) {
                sh.get(c).put(tmp, sh.get(c).getOrDefault(tmp, 0) + 1);
            }
        }
        if (depth == str.length || depth == course[course.length - 1]) return;
        for (int i = start; i < str.length; i++) {
            dfs(depth + 1, i + 1, str, course, tmp + str[i]);    
        }
                       
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        sh = new HashMap<Integer, HashMap<String, Integer>>();
        for (int x : course) sh.put(x, new HashMap<>());
        
        for (String x : orders) {
            char[] str = x.toCharArray();
            Arrays.sort(str);
            if (str.length < course[0]) continue;
            dfs(0, 0, str, course, "");
        }
        ArrayList<String> res = new ArrayList<>();
        
        for (int key : sh.keySet()) {
            if (sh.get(key).size() == 0) continue;
            HashMap<String, Integer> now = sh.get(key);
            ArrayList<Integer> arr = new ArrayList<>(now.values());
            Collections.sort(arr, (a, b) -> b - a);
            int max = arr.get(0);
            if (max < 2) continue;
            for (String k : now.keySet()) {
                if (now.get(k) == max) {
                    res.add(k);
                }
            }
        }
        Collections.sort(res, (a, b) -> a.compareTo(b));
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}