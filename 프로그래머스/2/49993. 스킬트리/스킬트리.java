import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashSet<Character> set = new HashSet<>();
        for (char x : skill.toCharArray()) set.add(x);
        for (String x : skill_trees) {
            String str = "";
            for (char c : x.toCharArray()) {
                if (set.contains(c)) str += c;
            }
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                if (skill.charAt(i) != str.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}