import java.util.*;
class Solution {
    public int getTime(String x) {
        int h = Integer.valueOf(x.split(":")[0]) * 60;
        int m = Integer.valueOf(x.split(":")[1]);
        return h + m;
    }
    
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> totalTime = new HashMap<>();
        HashMap<String, Integer> in = new HashMap<>();
        
        for (String x : records) {
            int time = getTime(x.split(" ")[0]);
            String number = x.split(" ")[1];
            if (in.containsKey(number)) {
                totalTime.put(number, totalTime.getOrDefault(number, 0) + (time - in.get(number)));
                in.remove(number);
            }
            else {
                in.put(number, time);
            }
        }
        
        for (String number : in.keySet()) {
            totalTime.put(number, totalTime.getOrDefault(number, 0) + (23 * 60 + 59) - in.get(number));
        }
      
        ArrayList<int[]> arr = new ArrayList<>();
        
        for (String number : totalTime.keySet()) {
            int time = totalTime.get(number);
            if (time <= fees[0]) {
                arr.add(new int[]{Integer.valueOf(number), fees[1]});
            }
            else {
                time -= fees[0];
                int sum = fees[1];
                sum += (time % fees[2] == 0) ? time / fees[2] * fees[3] : (time / fees[2] + 1) * fees[3];
                arr.add(new int[] {Integer.valueOf(number), sum});
            }
        }
        
        Collections.sort(arr, (a, b) -> a[0] - b[0]);
        
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i)[1];
        }
        
        return answer;
    }
}