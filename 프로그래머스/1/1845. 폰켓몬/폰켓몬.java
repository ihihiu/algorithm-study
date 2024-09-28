import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer, Integer> sh = new HashMap<>();
        for (int num : nums) {
            sh.put(num, sh.getOrDefault(num, 0) + 1);
        }
        int size = sh.size();
        if (size > n) return n;
        return size;
    }
}