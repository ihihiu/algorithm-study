import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int n = truck_weights.length;
        Queue<int[]> queue = new LinkedList<>();
        int nowWeight = 0;
        int i = 0, time = 0;
        while (i < n || !queue.isEmpty()) {
            if (!queue.isEmpty() && queue.peek()[0] == time) {
                int[] x = queue.poll();
                nowWeight -= x[1];
            }
            if (i < n && queue.size() < bridge_length && nowWeight + truck_weights[i] <= weight) {
                queue.offer(new int[]{time + bridge_length, truck_weights[i]});
                nowWeight += truck_weights[i];
                i++;
            }
            time++;
        }
        
        return time;
    }
}