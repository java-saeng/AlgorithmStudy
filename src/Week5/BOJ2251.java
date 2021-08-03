package Week5;

import java.io.*;
import java.util.*;

public class BOJ2251 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static int Limit[] = new int[3];
    static boolean possible[] = new boolean[201];
    static boolean visit[][][] = new boolean[201][201][201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            Limit[i] = atoi(st.nextToken());
        }

        bfs();

        for (int i = 0; i < possible.length; i++) {
            if(possible[i]){
                System.out.print(i + " ");
            }
        }
    }

    static void bfs() {
        Queue<Water> q = new ArrayDeque<>();

        q.offer(new Water(0, 0, Limit[2]));
        visit[0][0][Limit[2]] = true;

        while (!q.isEmpty()) {
            Water w = q.poll();
            if(w.a == 0) possible[w.c] = true;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == j) continue;
                    Water wt = w.move(i, j, Limit[j]);
                    if(visit[wt.a][wt.b][wt.c]) continue;
                    q.offer(wt);
                    visit[wt.a][wt.b][wt.c] = true;
                }
            }
        }
    }
    static class Water{
        int a, b, c;

        public Water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        Water move(int from, int to, int limit) {
            int arr[] = {a, b, c};
            if (arr[from] + arr[to] <= limit) {
                arr[to] = arr[to] + arr[from];
                arr[from] = 0;
            }
            else{
                arr[from] = arr[from] - (limit - arr[to]);
                arr[to] = limit;
            }
            return new Water(arr[0], arr[1], arr[2]);
        }
    }
}