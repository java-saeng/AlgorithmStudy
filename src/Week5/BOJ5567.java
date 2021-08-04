package Week5;

import java.io.*;
import java.util.*;

public class BOJ5567 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static ArrayList<Integer> al[];
    static boolean visit[];
    static int count[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());
        M = atoi(br.readLine());

        al = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        count = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());
            al[s1].add(s2);
            al[s2].add(s1);
        }
        bfs(1);

        int rel = 0;
        for (int i = 0; i <= N; i++) {
            if(count[i] >= 1 && count[i] <= 2){
                rel++;
            }
        }

        System.out.println(rel);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int element = q.poll();

            for (int i = 0; i < al[element].size(); i++) {
                int value = al[element].get(i);
                if (!visit[value]) {
                    q.offer(value);
                    visit[value] = true;
                    count[value] = count[element] + 1;
                }
            }
        }
    }
}