package Week6;

import java.io.*;
import java.util.*;

public class BOJ9205 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int n;
    static Point arr[];
    static ArrayList<Integer> al[];
    static boolean visit[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = atoi(br.readLine());

        for (int test = 0; test < test_case; test++) {
            n = atoi(br.readLine());

            arr = new Point[n + 2];
            visit = new boolean[n + 2];
            al = new ArrayList[n + 2];
            for (int i = 0; i < n + 2; i++) {
                al[i] = new ArrayList<>();
            }

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s1 = atoi(st.nextToken());
                int s2 = atoi(st.nextToken());

                arr[i] = new Point(s1, s2);
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (getDist(arr[i], arr[j]) <= 1000) {
                        al[i].add(j);
                        al[j].add(i);
                    }
                }
            }
            System.out.println(bfs());
        }
    }

    static String bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visit[0] = true;

        while (!q.isEmpty()) {
            int element = q.poll();
            if(element == n+1) return "happy";
            for (int i = 0; i < al[element].size(); i++) {
                int value = al[element].get(i);
                if(visit[value]) continue;
                q.offer(value);
                visit[value] = true;
            }
        }
        return "sad";
    }
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int getDist(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}