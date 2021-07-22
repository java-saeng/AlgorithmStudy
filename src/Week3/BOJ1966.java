package Week3;

//BOJ 1966 프린터 큐

import java.util.*;
import java.io.*;

public class BOJ1966 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int doc[];
    static int len, find;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = atoi(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            len = atoi(st.nextToken()); //문서 길이
            find = atoi(st.nextToken()); //찾아야하는 문서 번호

            q = new ArrayDeque<>();
            doc = new int[len];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len; i++) {
                doc[i] = atoi(st.nextToken());
                q.offer(i);
            }
            System.out.println(finddoc(find));
        }
    }

    static int finddoc(int num) {
        int cnt = 0;

        while (!q.isEmpty()) {
            int max = findMax();
            int value = q.poll();
            if(max == doc[value]){
                cnt++;
                doc[value] = -1;
                if (num == value) {
                    break;
                }
            }
            else{
                q.offer(value);
            }
        }
        return cnt;
    }

    static int findMax() {
        int max = -1;
        for (int i = 0; i < len; i++) {
            if(doc[i] > max){
                max = doc[i];
            }
        }
        return max;
    }
}