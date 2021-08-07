package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static int row, col, hei;
    static int arr[][][];
    static boolean visit[][][];
    static int dx[] = {-1, 0, 0, 1, 0, 0};
    static int dy[] = {0, 1, -1, 0, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int cnt;
    static Queue<Point> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = atoi(st.nextToken());
        row = atoi(st.nextToken());
        hei = atoi(st.nextToken());

        arr = new int[row][col][hei];
        visit = new boolean[row][col][hei];

        for (int i = 0; i < hei; i++) {
            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < col; k++) {
                    arr[j][k][i] = atoi(st.nextToken());
                    if(arr[j][k][i] == 1) {
                        q.offer(new Point(j, k, i, 0));
                        visit[j][k][i] = true;
                    }
                }
            }
        }
        bfs();
        if(check())
            System.out.println(cnt);
        else
            System.out.println(-1);

    }

    static void bfs() {
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 6; i++) {
                int dX = p.x + dx[i];
                int dY = p.y + dy[i];
                int dZ = p.z + dz[i];
                if(!isRangeTrue(dX,dY,dZ)) continue;
                if(visit[dX][dY][dZ]) continue;
                if(arr[dX][dY][dZ] != 0) continue;

                arr[dX][dY][dZ] = 1;
                visit[dX][dY][dZ] = true;
                q.offer(new Point(dX, dY, dZ, p.count + 1));
            }
            cnt = Math.max(cnt, p.count);
        }
    }

    static boolean check() {
        for (int i = 0; i < hei; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if(arr[j][k][i] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean isRangeTrue(int x, int y, int z) {
        return x >= 0 && x < row && y >= 0 && y < col && z >= 0 && z < hei;
    }
    static class Point{
        int x, y, z, count;

        public Point(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}
