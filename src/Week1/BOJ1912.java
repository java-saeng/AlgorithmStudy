package Week1;

import java.util.*;
import java.io.*;

public class BOJ1912 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = atoi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int dp[] = new int[size];
        int arr[] = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = atoi(st.nextToken());
        }

        dp[0] = arr[0];
        int max = arr[0];
        for(int i = 1; i < size; i++){
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
