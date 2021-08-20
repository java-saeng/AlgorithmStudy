package Week4;

import java.io.*;
import java.util.*;

public class BOJ18352 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int nV, nE;
    static ArrayList<Node> node[];
    static int dist[];
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        nV = atoi(st.nextToken());
        nE = atoi(st.nextToken());
        int K = atoi(st.nextToken());
        int start = atoi(st.nextToken());

        node = new ArrayList[nV + 1];
        dist = new int[nV + 1];

        for (int i = 0; i <= nV; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());

            node[from].add(new Node(to, 1));
        }

        dijkstra(start);

        for (int i = 1; i <= nV; i++) {
            if(dist[i] == K){
                sb.append(i).append("\n");
                continue;
            }
        }

        if(sb.length() == 0) System.out.println(-1);
        else System.out.print(sb);

    }

    static void dijkstra(int start) {
        for (int i = 0; i <= nV; i++) dist[i] = INF;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) ->{
            return o1.dist - o2.dist;
        });

        pq.offer(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if(dist[info.idx] != info.dist) continue;

            for (Node n : node[info.idx]) {
                if(dist[info.idx] + n.wei >= dist[n.to]) continue;

                dist[n.to] = dist[info.idx] + n.wei;
                pq.offer(new Info(n.to, dist[n.to]));
            }
        }
    }
    static class Info{
        int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    static class Node{
        int to, wei;

        public Node(int to, int wei) {
            this.to = to;
            this.wei = wei;
        }
    }

}
