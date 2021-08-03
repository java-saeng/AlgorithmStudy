package Week5;

import java.util.*;
import java.io.*;

public class BOJ14502{
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N,M;
    static int arr[][];
    static boolean visit[][];
    static int block[][];
    static int wall;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int rel;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];
        block = new int[N*M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = atoi(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    block[wall][0] = i;
                    block[wall][1] = j;
                    wall++;
                }
            }
        }

        dfs(0, 0);
        System.out.println(rel);
    }

    static void dfs(int index, int count) {
        if(count == 3){
            bfs();
            return;
        }

        if(index >= wall) return;

        arr[block[index][0]][block[index][1]] = 1;
        dfs(index + 1, count + 1);

        arr[block[index][0]][block[index][1]] = 0;
        dfs(index + 1, count);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = false;
                if(arr[i][j] == 2) {
                    q.offer(i);
                    q.offer(j);
                }
            }
        }

        while (!q.isEmpty()) {
            int X = q.poll();
            int Y = q.poll();
            for (int i = 0; i < 4; i++) {
                int dX = X + dx[i];
                int dY = Y + dy[i];
                if(!isRangeTrue(dX, dY)) continue;
                if(visit[dX][dY]) continue;
                if(arr[dX][dY] != 0) continue;
//                arr[dX][dY] = 2;
                visit[dX][dY] = true;
                q.offer(dX);
                q.offer(dY);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0 && !visit[i][j])
                    cnt++;
            }
        }
        rel = Math.max(cnt, rel);
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

/**
 * 1. 먼저 벽을 다 세운다,,
 * 0이 빈칸, 1이 벽 2가 바이러스
 */