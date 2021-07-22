package Week3;

//BOJ 1927 최소 힙

import java.util.*;
import java.io.*;

public class BOJ1927 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int tc = atoi(br.readLine());

        while (tc-- > 0) {
            int num = atoi(br.readLine());
            if(num == 0){
                if (pq.isEmpty()) {
                    sb.append(0 + "\n");
                }
                else {
                    sb.append(pq.poll() + "\n");
                }
                continue;
            }
            else{
                pq.offer(num);
            }
        }

        System.out.println(sb);
    }
}
