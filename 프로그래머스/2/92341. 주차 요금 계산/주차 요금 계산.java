import java.util.*;
class Solution {
    public int getTime(String x) {
        int h = Integer.valueOf(x.split(":")[0]) * 60;
        int m = Integer.valueOf(x.split(":")[1]);
        return h + m;
    }
    
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, ArrayList<Integer>> sh = new HashMap<>();
        for (String x : records) {
            int a = getTime(x.split(" ")[0]);
            int b = Integer.valueOf(x.split(" ")[1]);
            sh.putIfAbsent(b, new ArrayList<>());
            sh.get(b).add(a);
        }
        
        ArrayList<int[]> res = new ArrayList<>();
        
        for (int key : sh.keySet()) {
            ArrayList<Integer> arr = sh.get(key);
            
            Collections.sort(arr, (a, b) -> a - b);
            if (arr.size() % 2 == 1) arr.add(1439);
            
            int total = 0;
            for (int i = 0; i < arr.size(); i += 2) {
                int a = arr.get(i);
                int b = arr.get(i + 1);
                total += (b - a);
            }
            if (total <= fees[0]) res.add(new int[] {key, fees[1]});
            else {
                total -= fees[0];
                int k = total / fees[2];
                if (total % fees[2] != 0) k++;
                res.add(new int[] {key, fees[1] + k * fees[3]});
            }
        }
        
        Collections.sort(res, (a, b) -> a[0] - b[0]);
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i)[1];
        
        return answer;
    }
}