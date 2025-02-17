import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> sh = new HashMap<>();
        for (int x : tangerine) sh.put(x, sh.getOrDefault(x, 0) + 1);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int value : sh.values()) arr.add(value);
        Collections.sort(arr, (a, b) -> b - a);
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (sum >= k) return i + 1;
        }
        
        return 0;
    }
}