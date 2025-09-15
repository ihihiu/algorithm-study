import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        int n = phone_book.length;
        Arrays.sort(phone_book, (a, b) -> a.compareTo(b));
        
        for (int i = 0; i < n - 1; i++) {
            String a = phone_book[i];
            String b = phone_book[i + 1];
            boolean flag = true;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return false;
        }
        
        return true;
    }
}