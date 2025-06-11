import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') total++;
        }


        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            int bCnt = 0;
            for (int j = 0; j < total; j++) {
                int idx = (i + j < str.length() ? i + j : i + j - str.length());
                if (str.charAt(idx) == 'b') bCnt++;
            }
            answer = Math.min(answer, bCnt);
        }

        System.out.println(answer);


    }
}