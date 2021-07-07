package Week1;

//BOJ 10816 숫자 카드2

import java.util.*;
import java.io.*;

public class BOJ10816 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int N = atoi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int key = atoi(st.nextToken());
            if(map.containsKey(key)){
                int value = map.get(key);
                value++;
                map.put(key, value);
            }
            else{
                map.put(key, 1);
            }
        }

        int M = atoi(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            int key = atoi(st.nextToken());
            if(map.containsKey(key))
                sb.append(map.get(key) + " ");
            else
                sb.append(0 + " ");
        }
        System.out.print(sb);
    }
}
