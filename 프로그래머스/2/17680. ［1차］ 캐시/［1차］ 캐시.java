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
        
        if (cacheSize == 0) return cities.length * 5;
        
        LinkedList<Info> list = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            boolean hit = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).name.equals(city)) {
                    hit = true;
                    answer++;
                    list.get(j).ord = i;
                    break;
                }
            }
            if (!hit) {
                if (list.size() == cacheSize) {
                    Collections.sort(list);
                    list.poll();
                }
                list.offer(new Info(city, i));
                answer += 5;
            }
            
        }
        
        return answer;
    }
}