import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] pos = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = N;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int minPoint = 0;
            boolean flag = true;
            for (int i = 0; i < M; i++) {
                if (pos[i] - mid > minPoint) {
                    flag = false;
                    break;
                }
                minPoint = pos[i] + mid;
            }
            if (minPoint < N) flag = false;

            if (flag) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(lt);

    }

}