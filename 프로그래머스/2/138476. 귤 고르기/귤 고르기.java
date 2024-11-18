import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> sh = new HashMap<>();
        LinkedList<int[]> lst = new LinkedList<>();
        for (int x : tangerine) {
            sh.put(x, sh.getOrDefault(x, 0) + 1);
        }
        for (int x : sh.keySet()) {
            lst.offer(new int[]{x, sh.get(x)});
        }
        Collections.sort(lst, (a, b) -> b[1] - a[1]);
        while (!lst.isEmpty()) {
            int[] now = lst.poll();
            answer++;
            k -= now[1];
            if (k <= 0) break;
        }
        return answer;
    }
}