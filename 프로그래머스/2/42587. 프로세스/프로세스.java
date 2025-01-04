import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            list.add(new int[]{priorities[i], i});
        }
        Integer[] order = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(order, Collections.reverseOrder());
        int idx = 0;
        while (true) {
            int[] now = list.poll();
            if (now[0] == order[idx]) {
                idx++;
                if (now[1] == location) return idx;
            }
            else {
                list.add(now);
            }
        }
    }
}