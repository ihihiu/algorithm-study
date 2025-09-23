import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int N = truck_weights.length;
        int idx = 0;
        int time = 0;
        
        // (무게, 들어온 시간)
        Queue<int[]> bridge = new LinkedList<>();
        int bridgeWeight = 0;
        int size = 0;
        
        while (idx < N || bridge.isEmpty()) {
            // 나가는 시간이 된 트럭 처리
            if (!bridge.isEmpty() && time == bridge.peek()[1] + bridge_length) {
                int[] now = bridge.poll();
                bridgeWeight -= now[0];
                size--;
            }
            // 무게 측정하고 넣어주기
            if (idx < N && size < bridge_length && bridgeWeight + truck_weights[idx] <= weight) {
                bridge.add(new int[]{truck_weights[idx], time});
                size++;
                bridgeWeight += truck_weights[idx++];
            }
            time++;
        }
        
        return time + bridge_length;
    }
}