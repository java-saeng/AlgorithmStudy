package Week6;

import java.util.*;
import java.io.*;

public class BOJ2573 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int row, col;
    static int arr[][];
    static boolean visit[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int day;
    static ArrayList<Point> al;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = atoi(st.nextToken());
        col = atoi(st.nextToken());

        arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = atoi(st.nextToken());
            }
        }

        while (true) {
            visit = new boolean[row][col];
            al = new ArrayList<>();
            melting();
            day++;
            int ch = check();
            if(ch >= 2){
                System.out.println(day);
                break;
            }

            if(checkZero() && ch < 2){
                System.out.println(0);
                break;
            }
        }
    }

    static void melting() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] > 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int dX = i + dx[k];
                        int dY = j + dy[k];
                        if(!isRangeTrue(dX,dY)) continue;
                        if(arr[dX][dY] == 0) cnt++;
                    }
                    int value = arr[i][j] - cnt;
                    if(value > 0){
                        al.add(new Point(i, j, value));
                    }
                    else{
                        al.add(new Point(i, j, 0));
                    }
                }
            }
        }
        for (int i = 0; i < al.size(); i++) {
            int x = al.get(i).x;
            int y = al.get(i).y;
            arr[x][y] = al.get(i).value;
        }
    }

    static boolean checkZero() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j] > 0)
                    return false;
            }
        }
        return true;
    }

    static int check() {
        int component = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j] > 0 && !visit[i][j]){
                    bfs(i, j);
                    component++;
                }
            }
        }
        return component;
    }

    static void bfs(int x, int y) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        q.offer(y);
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int X = q.poll();
            int Y = q.poll();

            for(int i = 0; i < 4; i++){
                int dX = X + dx[i];
                int dY = Y + dy[i];
                if(!isRangeTrue(dX,dY)) continue;
                if(visit[dX][dY]) continue;
                if(arr[dX][dY] == 0) continue;
                q.offer(dX);
                q.offer(dY);
                visit[dX][dY] = true;
            }
        }
    }

    static class Point{
        int x, y, value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}