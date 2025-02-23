import java.util.*;
class Solution {
    static HashMap<Integer, HashMap<String, Integer>> sh;
    static int[] max;
    
    public void dfs(int depth, int start, String str, String tmp, int[] course) {
        if (depth > course[course.length - 1] || depth > str.length()) return;
        if (Arrays.stream(course).anyMatch(x -> x == depth)) {
            sh.get(depth).put(tmp, sh.get(depth).getOrDefault(tmp, 0) + 1);
            int value = sh.get(depth).get(tmp);
            if (value >= 2) max[depth] = Math.max(max[depth], value);
        }
        for (int i = start; i < str.length(); i++) {
            dfs(depth + 1, i + 1, str, tmp + str.charAt(i), course);
        }

    }
    
    public String[] solution(String[] orders, int[] course) {        
        sh = new HashMap<>(); 
        max = new int[11];
        for (int c : course) sh.put(c, new HashMap<String, Integer>());
        
        for (String str : orders) {
            if (str.length() >= course[0]) {
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                dfs(0, 0, String.valueOf(arr), "", course);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (int key: sh.keySet()) {
            if (max[key] == 0 || sh.get(key).isEmpty()) continue;
            for (String value : sh.get(key).keySet()) {
                if (sh.get(key).get(value) == max[key]) res.add(value);
            }
        }
        Collections.sort(res);
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);
    
     
        return answer;
    }
}