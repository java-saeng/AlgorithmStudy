package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644 {
    static int n, m;
    static ArrayList<Integer>[] al;
    static boolean visit[];
    static int start, end;
    static int count[];
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = atoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        start = atoi(st.nextToken());
        end = atoi(st.nextToken());

        visit = new boolean[n + 1];
        al = new ArrayList[n + 1];
        count = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            al[i] = new ArrayList<>();
        }
        m = atoi(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());

            al[s1].add(s2);
            al[s2].add(s1);
        }

        bfs();

        if (count[end] == 0) {
            System.out.println(-1);
        }
        else{
            System.out.println(count[end]);
        }
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int element = q.poll();
            for (int i = 0; i < al[element].size(); i++) {
                int value = al[element].get(i);
                if(visit[value]) continue;

                q.offer(value);
                visit[value] = true;
                count[value] = count[element] + 1;
            }
        }
    }
}
