import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for (int x : arr) {
            if (stack.peek() != x) stack.add(x);
        }
        
        return stack;
    }
}