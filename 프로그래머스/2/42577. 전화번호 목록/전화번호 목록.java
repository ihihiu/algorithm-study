import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int n = phone_book.length;
        HashMap<String, Integer> sh = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sh.put(phone_book[i], i);
        }        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < phone_book[i].length(); j ++) {
                if (sh.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }
        return answer;
    }
}