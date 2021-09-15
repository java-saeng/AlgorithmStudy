package Week10;

import java.io.*;
import java.util.*;

public class BOJ1939 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static class Node {
        int to, wei;

        public Node(int to, int wei) {
            this.to = to;
            this.wei = wei;
        }
    }

    static int N; //섬의 개수
    static int M; //간선 개수
    static ArrayList<Node> al[];
    static int max, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        al = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());
            int wei = atoi(st.nextToken());

            al[from].add(new Node(to, wei));
            al[to].add(new Node(from, wei));
            max = Math.max(max, wei);
        }

        st = new StringTokenizer(br.readLine());
        start = atoi(st.nextToken());
        end = atoi(st.nextToken());

        paraSearch();
    }

    //target이 중량
    static boolean bfs(int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        boolean visit[] = new boolean[N + 1];
        visit[start] = true;

        while (!q.isEmpty()) {
            int idx = q.poll();

            if (idx == end) return true;
            for (Node n : al[idx]) {
                if (visit[n.to]) continue;
                if (n.wei > target) continue;

                q.offer(n.to);
                visit[n.to] = true;
            }
        }
        return false;
    }

    static void paraSearch() {
        int s = 1, e = max, rel = 0;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (bfs(mid)) {
                rel = mid;
                s = mid + 1;
            }
            else e = mid - 1;
        }
        System.out.println(rel);
    }


}

