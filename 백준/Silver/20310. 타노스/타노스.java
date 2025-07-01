import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int zeroCnt = 0;
        int oneCnt = 0;

        for (char c : S.toCharArray()) {
            if (c == '0') zeroCnt++;
            else oneCnt++;
        }
        zeroCnt /= 2;
        oneCnt /= 2;

        StringBuilder sb = new StringBuilder(S);

        // 앞에서부터 1 없애기
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                sb.setCharAt(i, '2');
                oneCnt--;
            }
            if (oneCnt == 0) break;
        }

        // 뒤에서부터 0 없애기
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '2');
                zeroCnt--;
            }
            if (zeroCnt == 0) break;
        }

        String answer = sb.toString().replace("2", "");
        System.out.println(answer);

    }
}