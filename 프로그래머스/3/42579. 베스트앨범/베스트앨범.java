import java.util.*;

class Info implements Comparable<Info>{
    String genre;
    int total;
    
    public Info(String genre, int total) {
        this.genre = genre;
        this.total = total;
    }
    
    @Override
    public int compareTo(Info ob) {
        return ob.total - this.total;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> sh = new HashMap<>();
        HashMap<String, Integer> totals = new HashMap<>();
        ArrayList<Info> arr = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (!sh.containsKey(genres[i])) sh.put(genres[i], new ArrayList<>());
            sh.get(genres[i]).add(new int[]{plays[i], i});
            totals.put(genres[i], totals.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for (String key : totals.keySet()) {
            arr.add(new Info(key, totals.get(key)));
        }
        Collections.sort(arr, (a, b) -> b.total - a.total);
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            String g = arr.get(i).genre;
            ArrayList<int[]> tmp = sh.get(g);
            Collections.sort(tmp, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
            for (int j = 0; j < Math.min(2, tmp.size()); j++) {
                res.add(tmp.get(j)[1]);
            }
        }
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        
        return answer;
    }
}