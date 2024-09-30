import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int size = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (String x : operations) {
            char op = x.charAt(0);
            int num = Integer.parseInt(x.split(" ")[1]);
            if (op == 'I') {
                maxHeap.offer(num);
                minHeap.offer(num);
                size++;
            }
            else {
                if (size != 0){
                    if (num == 1) minHeap.remove(maxHeap.poll());
                    else maxHeap.remove(minHeap.poll());
                    size--;
                }
            }
            
        }
        if (size == 0) return answer;
        answer[0] = maxHeap.poll();
        answer[1] = minHeap.poll();
        return answer;
    }
}