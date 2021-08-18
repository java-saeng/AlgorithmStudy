package Week7;

import java.io.*;
import java.util.*;

public class BOJ6443 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int arr[];
    static char save[];
    static StringBuilder sb = new StringBuilder();
    static int len;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = atoi(br.readLine());

        while (test-- > 0) {
            String str = br.readLine();
            len = str.length();

            arr = new int[26];
            save = new char[len];

            for (int i = 0; i < len; i++) {
                arr[str.charAt(i) - 'a']++;
            }

            dfs(0);
        }

        System.out.println(sb);

    }

    static void dfs(int cnt) {
        if (cnt == len) {
            sb.append(save).append("\n"); //char배열은 그대로 출력하면 String처럼 나온다.
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                arr[i]--;
                save[cnt] = (char) (i + 'a');
                dfs(cnt + 1);
                arr[i]++;
            }
        }
    }
}
/*
dfs의 파라미터로 string을 계속 전달하는것보다
ch라는 배열을 만들어서 한번에 sb에 넣는게
메모리 거의 절반토막나고, 시간도 준다.
 */