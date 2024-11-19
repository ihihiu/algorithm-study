import java.util.*;
class Solution {
    public int getTime(String x) {
        int h = Integer.parseInt(x.split(":")[0]);     
        int m = Integer.parseInt(x.split(":")[1]);
        return h * 60 + m;
    }
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, ArrayList<Integer>> sh = new HashMap<>();
        LinkedList<int[]> res = new LinkedList<>();
        for (String x : records) {
            int a = Integer.parseInt(x.split(" ")[1]);
            int b = getTime(x.split(" ")[0]);
            if (!sh.containsKey(a)) sh.put(a, new ArrayList<Integer>());
            sh.get(a).add(b);
        }
        for (int key : sh.keySet()) {
            ArrayList<Integer> arr = sh.get(key);
            if (arr.size() % 2 == 1) arr.add(23 * 60 + 59);
            int sum = 0, price = fees[1];
            for (int i = 0; i < arr.size(); i += 2) {
                sum += arr.get(i + 1) - arr.get(i);
            }
            if (sum > fees[0]) {
                sum -= fees[0];
                price += (sum / fees[2] * fees[3]);
                if (sum % fees[2] != 0) price += fees[3];
            }
            res.add(new int[]{key, price});
        }
        Collections.sort(res, (a, b) -> a[0] - b[0]);
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i)[1];
        }
        return answer;
    }
}