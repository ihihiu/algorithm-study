import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] sets = s.split("\\},\\{");
        Arrays.sort(sets, (a, b) -> a.length() - b.length());
        
        List<Integer> arr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (String x : sets) {
            String[] nums = x.split(",");
            for (String num : nums) {
                int n = Integer.parseInt(num);
                if (!set.contains(n)) {
                    set.add(n);
                    arr.add(n);
                }
            }
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;

    }
}