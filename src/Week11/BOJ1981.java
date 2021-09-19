package Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1981 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
    static int A[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = atoi(st.nextToken());
            }
        }

        paraSearch();
    }

    //target은 여기서 최대값 - 최소값
    static boolean possible(int target) {
        for(int i = 0; i + target <= 200; i++){

            if(A[0][0] < i || A[0][0] > i + target) continue;

            Queue<Point> q = new ArrayDeque<>();
            q.offer(new Point(0, 0));
            boolean visit[][] = new boolean[N][N];
            visit[0][0] = true;

            while (!q.isEmpty()) {
                Point pt = q.poll();

                if(pt.x == N-1 && pt.y == N-1) return true;
                for (int j = 0; j < 4; j++) {
                    int X = pt.x + dx[j];
                    int Y = pt.y + dy[j];

                    if(!isRangeTrue(X,Y)) continue;
                    if(visit[X][Y]) continue;
                    if(A[X][Y] < i || A[X][Y] > i + target) continue;

                    q.offer(new Point(X, Y));
                    visit[X][Y] = true;
                }
            }
        }
        return false;
    }

    static void paraSearch() {
        int s = 0, e = 200, rel = 0;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (possible(mid)) {
                e = mid - 1;
                rel = mid;
            }
            else s = mid + 1;
        }

        System.out.println(rel);
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static class Point{
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
