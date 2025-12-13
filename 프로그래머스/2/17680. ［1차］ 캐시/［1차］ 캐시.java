import java.util.*;

class Info implements Comparable<Info> {
    String name;
    int cnt;
    
    public Info(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
    }
    
    @Override
    public int compareTo(Info ob) {
        return this.cnt - ob.cnt;
    }
    
}

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<Info> cache = new LinkedList<>();
        
        int idx = 0;
        for (String c : cities) {
            String city = c.toUpperCase();
            if (cacheSize == 0) {
                answer += 5;
                continue;
            }
            boolean isHit = false;
            for (int i = 0; i < cache.size(); i++) {
                if (city.equals(cache.get(i).name)) {
                    isHit = true;
                    cache.get(i).cnt = idx;
                    answer += 1;
                    break;
                }
            }
            if (!isHit) {
                if (cache.size() == cacheSize) {
                    Collections.sort(cache);
                    cache.remove(0);
                }
                cache.add(new Info(city, idx));
                answer += 5;
            }
            idx++;
        }
        
        
        return answer;
    }
}