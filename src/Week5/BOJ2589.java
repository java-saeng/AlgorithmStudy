package Week5;

import java.io.*;
import java.util.*;

public class BOJ2589 {
    static int row, col;
    static char arr[][];
    static boolean visit[][];
    static int rel;
    static int count[][];

    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = atoi(st.nextToken());
        col = atoi(st.nextToken());

        arr = new char[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        findrand();
        System.out.println(rel);
    }

    static void findrand() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j] == 'L'){
                    visit = new boolean[row][col];
                    count = new int[row][col];
                    bfs(i, j);
                }
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        q.offer(y);
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int X = q.poll();
            int Y = q.poll();
            for (int i = 0; i < 4; i++) {
                int dX = X + dx[i];
                int dY = Y + dy[i];
                if(!isRangeTrue(dX,dY)) continue;
                if(visit[dX][dY]) continue;
                if(arr[dX][dY] != 'L') continue;
                visit[dX][dY] = true;
                q.offer(dX);
                q.offer(dY);
                count[dX][dY] = count[X][Y] + 1;
                rel = Math.max(rel, count[dX][dY]);
            }
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}