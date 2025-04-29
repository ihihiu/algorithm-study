import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        HashMap<Integer, Character> sh = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            sh.put(i, skill.charAt(i));
            set.add(skill.charAt(i));
        }
        
        for (String x : skill_trees) {
            int idx = 0;
            boolean flag = true;
            for (int i = 0; i < x.length(); i++) {
                char now = x.charAt(i);
                if (!set.contains(now)) continue;
                else {
                    if (now != sh.get(idx)) {
                        flag = false;
                        break;
                    }
                    else idx++;
                }
            }
            if (flag) answer++;
        }
        
        return answer;
    }
}