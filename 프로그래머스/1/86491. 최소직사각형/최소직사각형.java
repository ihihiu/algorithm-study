import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int x = 0, y = 0;
        for (int[] size : sizes) {
            if (size[0] > size[1]) {
                if (size[0] > x) x = size[0];
                if (size[1] > y) y = size[1];
            }
            else {
                if (size[1] > x) x = size[1];
                if (size[0] > y) y = size[0];
            }
        }
        answer = x * y;
        return answer;
    }
}