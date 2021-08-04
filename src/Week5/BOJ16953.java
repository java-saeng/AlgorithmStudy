package Week5;

import java.util.*;
import java.io.*;

public class BOJ16953 {
    static long atoi(String str) {
        return Long.parseLong(str);
    }
    static class Point{
        long x;
        int cnt;

        public Point(long x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
    static long start, target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = atoi(st.nextToken());
        target = atoi(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> q = new ArrayDeque<>();

        q.offer(new Point(start, 1));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if(p.x == target) {
                return p.cnt;
            }
            if(p.x * 2 <= target)
                q.offer(new Point(p.x * 2, p.cnt + 1));
            if(p.x * 10 + 1 <= target)
                q.offer(new Point(p.x * 10 + 1, p.cnt + 1));
        }
        return -1;
    }
}