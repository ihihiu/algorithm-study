import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int n = truck_weights.length;
        //(무게, 건너는 시간)
        LinkedList<int[]> queue = new LinkedList<>();
        
        int sum = 0;
        int idx = 0;
        int time = 0;
        while (idx < n) {
            if (!queue.isEmpty() && time == queue.peek()[1]) {
                sum -= queue.poll()[0];
            }
            if (idx < n && sum + truck_weights[idx] <= weight) {
                queue.offer(new int[]{truck_weights[idx], time + bridge_length});
                sum += truck_weights[idx];
                idx++;
            }
            time++;
        }
        
        return time + bridge_length;
    }
}