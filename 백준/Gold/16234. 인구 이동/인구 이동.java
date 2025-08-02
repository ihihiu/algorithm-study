import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int answer = 0;

        while (true) {
            boolean flag = false;
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    visited[i][j] = true;
                    LinkedList<int[]> list = new LinkedList<>();
                    list.offer(new int[]{i, j});
                    int idx = 0;
                    int sum = 0;
                    while (list.size() > idx) {
                        int[] now = list.get(idx++);
                        sum += A[now[0]][now[1]];
                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                            if (Math.abs(A[now[0]][now[1]] - A[nx][ny]) >= L && Math.abs(A[now[0]][now[1]] - A[nx][ny]) <= R) {
                                list.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    if (list.size() > 1) {
                        flag = true;
                        sum /= list.size();
                        for (int[] x : list) {
                            A[x[0]][x[1]] = sum;
                        }
                    }

                }
            }
            if (flag == false) {
                System.out.println(answer);
                break;
            }
            answer++;
        }

    }
}

