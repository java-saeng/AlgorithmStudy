package Week8;

import java.io.*;
import java.util.*;

public class BOJ2206 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static int row, col;
    static int arr[][];
    static boolean visit[][][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = atoi(st.nextToken());
        col = atoi(st.nextToken());

        arr = new int[row][col];
        visit = new boolean[row][col][2];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

    }

    static void bfs() {
        Queue<Wall> q = new ArrayDeque<>();
        q.offer(new Wall(0, 0, 1, 0));

        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Wall wall = q.poll();
            int x = wall.x;
            int y = wall.y;
            int cnt = wall.cnt;
            int breakwall = wall.breakwall;

            if (x == row - 1 && y == col - 1) {
                System.out.println(cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if(!isRangeTrue(X,Y)) continue;

                if(arr[X][Y] == 1){
                    if(breakwall == 0 && !visit[X][Y][1]){
                        q.offer(new Wall(X, Y, cnt + 1, 1));
                        visit[X][Y][1] = true;
                    }
                }
                else{
                    if(!visit[X][Y][breakwall]){
                        q.offer(new Wall(X, Y, cnt + 1, breakwall));
                        visit[X][Y][breakwall] = true;
                    }
                }
            }
        }
        System.out.println(-1);

    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    static class Wall{
        int x, y, cnt, breakwall;

        public Wall(int x, int y, int cnt, int breakwall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breakwall = breakwall;
        }
    }
}
