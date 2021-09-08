package Week10;

import java.io.*;
import java.util.*;

public class BOJ1920 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N; // 숫자개수
    static int a[];
    static int M; //있는지 없는지 확인해야할 숫자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        a = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = atoi(st.nextToken());
        }

        Arrays.sort(a);

        M = atoi(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(atoi(st.nextToken()))).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int target) {
        int s = 0, e = N-1, rel = 0;
        //s e는 index를 뜻한다.
        while (s <= e) {
            int mid = (s + e) / 2;

            if(a[mid] > target) e = mid - 1;
            else if(a[mid] == target) return 1;
            else s = mid + 1;
        }
        return 0;
    }
}
