import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int N = operations.length;
        
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        int size = 0;
        
        for (int i = 0; i < N; i++) {
            char op = operations[i].charAt(0);
            int num = Integer.parseInt(operations[i].split(" ")[1]);
            if (op == 'I') {
                maxQ.add(num);
                minQ.add(num);
                size++;
            }
            else {
                if (size != 0) {
                    if (num == -1) {
                        maxQ.remove(minQ.poll());
                    }
                    if (num == 1) {
                        minQ.remove(maxQ.poll());
                    }
                    size--;
                }
            }
        }
        
        if (size == 0) return answer;
        else {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        
        return answer;
    }
}