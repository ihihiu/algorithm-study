import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) break;

            boolean flag = true;

            boolean containVowel = false;
            char preChar = '#';
            int vowelCnt = 0;
            int conCnt = 0;

            for (int i = 0; i < str.length(); i++) {
                if (preChar == str.charAt(i)) {
                    flag = false;
                    break;
                }
                if (vowel.contains(str.charAt(i))) {
                    containVowel = true;
                    if (str.charAt(i) == 'e' && i + 1 < str.length() && str.charAt(i + 1) == 'e') {
                        i++;
                        vowelCnt++;
                    }
                    else if (str.charAt(i) == 'o' && i + 1 < str.length() && str.charAt(i + 1) == 'o') {
                        i++;
                        vowelCnt++;
                    }
                    vowelCnt++;
                    conCnt = 0;
                } else {
                    vowelCnt = 0;
                    conCnt++;
                }
                if (vowelCnt >= 3 || conCnt >= 3) {
                    flag = false;
                    break;
                }
                preChar = str.charAt(i);
            }

            if (flag && containVowel) {
                System.out.println("<" + str + "> is acceptable.");
            } else {
                System.out.println("<" + str + "> is not acceptable.");
            }


        }

    }
}