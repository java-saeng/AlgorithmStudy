package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14503 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static int arr[][];
    static boolean visit[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        Point robot = new Point(atoi(st.nextToken()), atoi(st.nextToken()), atoi(st.nextToken()));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = atoi(st.nextToken());
            }
        }

        dfs(robot);

        System.out.println(cnt);
    }

    static void dfs(Point p) {
        boolean flag = false;
        if(!visit[p.x][p.y]) {
            arr[p.x][p.y] = 2;
            cnt++;
        }
        visit[p.x][p.y] = true;
        int dir = p.dir;
        for (int i = 0; i < 4; i++) {
            dir = finddir(dir); //이 부분
            int X = p.x + dx[dir];
            int Y = p.y + dy[dir];
            if(visit[X][Y]) continue;
            if(arr[X][Y] != 0) continue;
            flag = true;
            dfs(new Point(X, Y, dir));
            break;
        }

        if (!flag) {
            int X = p.x - dx[dir];
            int Y = p.y - dy[dir];
            if(arr[X][Y] != 1) dfs(new Point(X, Y,dir));
        }

    }

    static int finddir(int x) {
        int dir = x - 1;
        if(dir < 0) return 3;
        return dir;
    }

    static class Point{
        int x, y, dir;

        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}