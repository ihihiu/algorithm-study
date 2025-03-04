import java.util.*;

class Info implements Comparable<Info> {
    String name;
    int ord;
    public Info(String name, int ord) {
        this.name = name;
        this.ord = ord;
    }
    @Override
    public int compareTo(Info ob) {
        return this.ord - ob.ord;
    }
}

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) return 5 * cities.length;
        LinkedList<Info> list = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            boolean hit = false;
            if (!list.isEmpty()) {
                for (Info x : list) {
                    if (x.name.equals(city)) {
                        answer++;
                        hit = true;
                        x.ord = i;
                        break;
                    }
                }
            }
            if (!hit) {
                if (list.size() == cacheSize) list.poll();
                list.offer(new Info(city, i));
                answer += 5;
            }
            Collections.sort(list);
        }
        return answer;
    }
}