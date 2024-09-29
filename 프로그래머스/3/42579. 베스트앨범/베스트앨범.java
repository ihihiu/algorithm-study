import java.util.*;
class Info implements Comparable<Info> {
    public int play;
    public int idx;
    
    Info(int play, int idx) {
        this.play = play;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Info ob) {
        if (this.play == ob.play) return this.idx - ob.idx;
        return ob.play - this.play;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<String, Integer> sh1 = new HashMap<>();
        HashMap<String, ArrayList<Info>> sh2 = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            sh1.put(genres[i], sh1.getOrDefault(genres[i], 0) + plays[i]);
            if (!sh2.containsKey(genres[i])) {
                sh2.put(genres[i], new ArrayList<>());
            }
            sh2.get(genres[i]).add(new Info(plays[i], i));
        }

        ArrayList<String> keys = new ArrayList<>(sh1.keySet());
        Collections.sort(keys, (a, b) -> sh1.get(b) - sh1.get(a));
        for (String key : keys) {
            ArrayList<Info> arr = sh2.get(key);
            Collections.sort(arr);
            res.add(arr.get(0).idx);
            if (arr.size() >= 2)  res.add(arr.get(1).idx);
        }
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        
        return answer;
    }
}