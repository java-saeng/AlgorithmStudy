package Week8;

import java.io.*;
import java.util.*;

public class BOJ16946 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int row, col;
    static int arr[][];
    static int group[];
    static boolean visit[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        row = atoi(st.nextToken());
        col = atoi(st.nextToken());

        arr = new int[row][col];
        group = new int[row * col + 2];
        visit = new boolean[row][col];
        int idx = 2;

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j] == 0 && !visit[i][j]){
                    bfs(i, j, idx);
                    idx++;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j] == 1){
                    sb.append(search(i,j));
                }
                else{
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    static void bfs(int x, int y, int idx) {
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        q.offer(y);
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int X = q.poll();
            int Y = q.poll();
            cnt++;
            arr[X][Y] = idx;
            for (int i = 0; i < 4; i++) {
                int dX = X + dx[i];
                int dY = Y + dy[i];

                if(!isRangeTrue(dX,dY)) continue;
                if(visit[dX][dY]) continue;
                if(arr[dX][dY] != 0) continue;

                visit[dX][dY]= true;
                q.offer(dX);
                q.offer(dY);
            }
        }

        group[idx] = cnt;
    }

    static int search(int x, int y) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if(!isRangeTrue(X,Y)) continue;

            set.add(arr[X][Y]);
        }

        int sum = 0;

        for(int val : set){
            sum += group[val];
        }

        return (sum + 1) % 10;
    }

    /*
    static int search(int x, int y) {
        int sum = 1;
        boolean v[] = new boolean[row * col + 3];
        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if(!isRangeTrue(X,Y)) continue;
            if(v[arr[X][Y]]) continue;
            if(arr[X][Y] == 1) continue;

            sum += group[arr[X][Y]];
            v[arr[X][Y]] = true;
        }
        return sum % 10;
    }
     */

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}