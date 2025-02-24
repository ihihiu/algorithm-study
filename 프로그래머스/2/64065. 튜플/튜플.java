import java.util.*;
class Solution {
    public int[] solution(String s) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            String now = "";
            while (s.charAt(i) != '}') {
                if (s.charAt(i) == ',') {
                    tmp.add(Integer.valueOf(now));
                    now = "";
                } 
                else if(s.charAt(i) != '{') {
                    now += s.charAt(i);
                }
                i++;
            }
            tmp.add(Integer.valueOf(now));
            i++;
            if (!tmp.isEmpty()) arr.add(tmp);
        }
       
        Collections.sort(arr, (a, b) -> a.size() - b.size());
        int[] answer = new int[arr.size()];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int value : arr.get(i)) {
                if (!set.contains(value)) {
                    set.add(value);
                    answer[i] = value;
                    break;
                }
            }
        }
        return answer;
    }
}