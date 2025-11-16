import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        
        Arrays.sort(nums);
        
        answer += String.valueOf(nums[0]);
        answer += " ";
        answer += String.valueOf(nums[str.length - 1]);
        
        return answer;
    }
}