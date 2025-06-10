import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            boolean find = false;
            StringBuilder answer = new StringBuilder();

            // 첫 글자 확인
            for (int j = 0; j < arr.length; j++) {
                if (set.isEmpty() || !set.contains(Character.toUpperCase(arr[j].charAt(0)))) {
                    set.add(Character.toUpperCase(arr[j].charAt(0)));
                    find = true;
                    StringBuilder sb = new StringBuilder(arr[j]);
                    sb.insert(0, '[');
                    sb.insert(2, ']');
                    arr[j] = sb.toString();
                    for (int k = 0; k < arr.length; k++) {
                        if (k == arr.length - 1) answer.append(arr[k]);
                        else answer.append(arr[k]).append(" ");
                    }
                    System.out.println(answer);
                    break;
                }
            }
            if (!find) {
                for (int j = 0; j < arr.length; j++) {
                    for (int l = 0; l < arr[j].length(); l++) {
                        if (!set.contains(Character.toUpperCase(arr[j].charAt(l)))) {
                            set.add(Character.toUpperCase(arr[j].charAt(l)));
                            find = true;

                            StringBuilder sb = new StringBuilder(arr[j]);
                            sb.insert(l, '[');
                            sb.insert(l + 2, ']');
                            arr[j] = sb.toString();

                            for (int k = 0; k < arr.length; k++) {
                                if (k == arr.length - 1) answer.append(arr[k]);
                                else answer.append(arr[k]).append(" ");
                            }
                            System.out.println(answer);
                        }
                        if (find) break;
                    }
                }
            }
            if (!find) System.out.println(str);
        }
    }
}