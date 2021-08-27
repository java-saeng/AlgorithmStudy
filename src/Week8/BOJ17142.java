package Week8;

import java.io.*;
import java.util.*;

public class BOJ17142 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static int arr[][], count[][], block[][];
    static boolean visit[][];
    static int wall, area;
    static int rel = Integer.MAX_VALUE;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        arr = new int[N][N];
        count = new int[N][N];
        block = new int[N * N][2];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = atoi(st.nextToken());
                if(arr[i][j] == 2){
                    block[wall][0] = i;
                    block[wall][1] = j;
                    wall++;
                }
                else if(arr[i][j] == 0) area++;
            }
        }

        dfs(0, 0);

        if(area == 0) System.out.println(0);
        else {
            if (rel == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(rel);
        }
    }

    static void dfs(int idx, int cnt) {
        if(cnt == wall - M){
            bfs();
        }

        if(idx == wall) return;

        arr[block[idx][0]][block[idx][1]] = -1;
        dfs(idx + 1, cnt + 1);
        arr[block[idx][0]][block[idx][1]] = 2;
        dfs(idx + 1, cnt);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;
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
                if(arr[dX][dY] == 1) continue;
                if(visit[dX][dY]) continue;

                if(arr[dX][dY] == 0) cnt++;

                q.offer(dX);
                q.offer(dY);
                visit[dX][dY] = true;
                count[dX][dY] = count[X][Y] + 1;

                if(cnt == area){
                    rel = Math.min(rel, count[dX][dY]);
                }
            }
            /*if(cnt == area){
                rel = Math.min(rel, count[dX][dY]);
            }*/
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}