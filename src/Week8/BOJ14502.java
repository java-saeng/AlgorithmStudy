package Week8;

import java.io.*;
import java.util.*;

public class BOJ14502 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int row, col;
    static int arr[][], block[][];
    static boolean visit[][];
    static int wall;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int rel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = atoi(st.nextToken());
        col = atoi(st.nextToken());

        arr = new int[row][col];
        block = new int[row * col][2];
        visit = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = atoi(st.nextToken());
                if(arr[i][j] == 0){
                    block[wall][0] = i;
                    block[wall][1] = j;
                    wall++;
                }
            }
        }
        dfs(0, 0);
        System.out.println(rel);
    }

    static void dfs(int idx, int cnt) {
        if (cnt == 3) {
            bfs();
            rel = Math.max(rel, check());
            return;
        }

        if(idx == wall) return;

        arr[block[idx][0]][block[idx][1]] = 1;
        dfs(idx + 1, cnt + 1);
        arr[block[idx][0]][block[idx][1]] = 0;
        dfs(idx + 1, cnt);
    }
    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
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
                if(visit[dX][dY]) continue;
                if(arr[dX][dY] != 0) continue;

                q.offer(dX);
                q.offer(dY);
                visit[dX][dY] = true;
            }
        }
    }

    static int check() {
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j] == 0 && !visit[i][j]) cnt++;
            }
        }
        return cnt;
    }
    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
