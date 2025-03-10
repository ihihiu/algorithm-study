import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 4;
        int[][] arr = new int[5][8];
        for (int i = 1; i <= n; i++) {
            String s = scanner.next();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }


        int k = scanner.nextInt();
        int[] top = new int[5];

        for (int i = 0; i < k; i++) {
            int idx = scanner.nextInt();
            int dir = scanner.nextInt();

            //idx 톱니를 회전
            ArrayList<int[]> tmp = new ArrayList<>();
            tmp.add(new int[]{idx, 0});

            // idx 우측 방향 처리
            for (int j = idx + 1; j <= n; j++) {
                //왼쪽 3시 != 오른쪽 9시 -> 회전 후보 추가
                if (arr[j - 1][(top[j - 1] + 2) % 8] != arr[j][(top[j] + 6) % 8]) {
                    tmp.add(new int[]{j, (j - idx) % 2});
                }
                else break;
            }

            // idx 좌측 방향 처리
            for (int j = idx - 1; j >= 1; j--) {
                //왼쪽 3시 != 오른쪽 9시 -> 회전 후보 추가
                if (arr[j][(top[j] + 2) % 8] != arr[j + 1][(top[j + 1] + 6) % 8]) {
                    tmp.add(new int[]{j, (idx - j) % 2});
                }
                else break;
            }

            //실제 회전 처리
            for (int[] x : tmp) {
                if (x[1] == 0) {
                    top[x[0]] = (top[x[0]] - dir + 8) % 8;
                }
                else {
                    top[x[0]] = (top[x[0]] + dir + 8) % 8;
                }
            }
        }

        int answer = 0;
        int[] score = {0, 1, 2, 4, 8};
        for (int i = 1; i <= n; i++) {
            answer += arr[i][top[i]] * score[i];
        }
        System.out.println(answer);
    }
}