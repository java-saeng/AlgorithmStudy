package Week3;

//BOJ 11279 최대 힙

import java.util.*;
import java.io.*;

public class BOJ11279 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> {return o2-o1;}
        );
        //비교 대상에 Collections.reverseOrder() 사용 가능
        
        int tc = atoi(br.readLine());

        while (tc-- > 0) {
            int num = atoi(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append(0 + "\n");
                }
                else{
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
