package Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638 {
    static int arr[][];
    static boolean visit[][];
    static int row, col;
    static int day, cheese;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = atoi(st.nextToken());
        col = atoi(st.nextToken());

        arr = new int[row][col];
        visit = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = atoi(st.nextToken());
                if(arr[i][j] == 1) cheese++;
            }
        }


        while(cheese > 0) {
            makeAir();
            meltCheese();
            init();
            ++day;
        }

        System.out.println(day);

    }

    static void init() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visit[i][j] = false;
                if (arr[i][j] == 0 || arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void meltCheese() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int X = i + dx[k];
                        int Y = j + dy[k];
                        if(arr[X][Y] == -1){
                            cnt++;
                        }
                        if (cnt == 2) {
                            arr[i][j] = 0;
                            cheese--;
                            break;
                        }
                    }
                }
            }
        }
    }
    static void makeAir() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        q.offer(0);
        visit[0][0] = true;
        arr[0][0] = -1;

        while (!q.isEmpty()) {
            int X = q.poll();
            int Y = q.poll();
            for (int i = 0; i < 4; i++) {
                int dX = X + dx[i];
                int dY = Y + dy[i];
                if(!isRangeTrue(dX,dY)) continue;
                if(visit[dX][dY]) continue;
                if(arr[dX][dY] != 0) continue;
                visit[dX][dY] = true;
                q.offer(dX);
                q.offer(dY);
                arr[dX][dY] = -1;
            }
        }
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}