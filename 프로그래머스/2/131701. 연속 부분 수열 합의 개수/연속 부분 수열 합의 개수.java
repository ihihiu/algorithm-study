import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            set.add(elements[i]);
            sum += elements[i];
        }
        set.add(sum);
        for (int i = 2; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int tmp = 0;
                for (int k = 0; k < i; k++) {
                    if (j + k >= elements.length) {
                        tmp += elements[j + k - elements.length];
                    }
                    else tmp += elements[j + k];
                }
                set.add(tmp);
            }
        }
        
        return set.size();
    }
}