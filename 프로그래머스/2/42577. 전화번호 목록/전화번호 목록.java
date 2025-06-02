import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 1. HashMap 만들기
        HashMap<String, Integer> sh = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) sh.put(phone_book[i], 1);
        
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (sh.containsKey(phone_book[i].substring(0, j))) return false;
            }
        }
        
        
        return answer;
    }
}