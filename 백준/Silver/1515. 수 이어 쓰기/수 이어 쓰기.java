import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        int p = 0;
        int base = 1;
        while (base <= 30000) {
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == str.charAt(p)) p++;
                if (p == str.length()) {
                    System.out.println(base);
                    return;
                }
            }
            base++;
        }
    }
}