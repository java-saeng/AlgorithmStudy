package Week1;

//BOJ 11866 요세푸스 문제 0

import java.util.*;
import java.io.*;

public class BOJ11866 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();

        int N = atoi(st.nextToken());
        int K = atoi(st.nextToken());

        /////////////////////////////////////입력

        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        sb.append("<");
        int pos = 0;
        while(q.size() != 1){
            int element = q.poll();
            pos++;
            if(pos % K == 0){
                sb.append(element + ", ");
                pos = 0;
            }
            else{
                q.offer(element);
            }
        }

        sb.append(q.poll() + ">");

        System.out.print(sb);
    }
}
