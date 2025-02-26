import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashSet<Character> set = new HashSet<>();
        for (char x : skill.toCharArray()) set.add(x);
        for (String x : skill_trees) {
            int idx = 0;
            boolean flag = true;
            for (char now : x.toCharArray()) {
                if (set.contains(now)) {
                    if (now == skill.charAt(idx)) {
                        idx++;
                        if (idx == skill.length()) break;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}