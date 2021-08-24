package Week8;

import java.io.*;
import java.util.*;

public class BOJ17141 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, wall, M, zeroCnt;
    static int arr[][], count[][], virus[][];
    static boolean visit[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int rel = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        arr = new int[N][N];
        count = new int[N][N];
        virus = new int[N * N][2];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = atoi(st.nextToken());
                if(arr[i][j] == 2){
                    virus[wall][0] = i;
                    virus[wall][1] = j;
                    wall++;
                }
                else if(arr[i][j] == 0) zeroCnt++;
            }
        }
        zeroCnt += wall - M;

        dfs(0, 0);

        if(rel == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(rel);
    }

    static void dfs(int idx, int cnt) {
        if (cnt == wall - M) {
            bfs();
        }

        if(idx == wall) return;

        arr[virus[idx][0]][virus[idx][1]] = 0;
        dfs(idx + 1, cnt + 1);
        arr[virus[idx][0]][virus[idx][1]] = 2;
        dfs(idx + 1, cnt);
    }

    static void bfs() {
        int cnt = 0;
        int area = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count[i][j] = 0;
                visit[i][j] = false;
                if(arr[i][j] == 2){
                    q.offer(i);
                    q.offer(j);
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int X = q.poll();
            int Y = q.poll();

            for (int i = 0; i < 4; i++) {
                int dX = X + dx[i];
                int dY = Y + dy[i];
                if(!isRangeTrue(dX,dY)) continue;
                if(arr[dX][dY] != 0) continue;
                if(visit[dX][dY]) continue;

                q.offer(dX);
                q.offer(dY);
                visit[dX][dY] = true;
                count[dX][dY] = count[X][Y] + 1;
                cnt = count[dX][dY];
                area++;
            }
        }
        if (area == zeroCnt) {
            rel = Math.min(rel, cnt);
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}