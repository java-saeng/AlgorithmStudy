package Week10;

import java.io.*;
import java.util.*;

public class BOJ1764 {
    static int N; //듣기
    static int M; //보기
    static String A[];
    static ArrayList<String> al = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new String[N];

        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }

        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            binarySearch(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        sb.append(al.size()).append("\n");
        Collections.sort(al);
        for (String s : al) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    static void binarySearch(String target) {
        //s와 e는 idx를 뜻함
        int s = 0, e = N-1, rel = 0;
        while (s <= e) {
            int mid = (s + e) / 2;

            if(A[mid].equals(target)) {
                al.add(target);
                return;
            }
            //A.compareTo(B) 일때
            //음수이면 A가 B보다 앞에 있다.
            else if(A[mid].compareTo(target) < 0) s = mid + 1;
            else e = mid - 1;
        }
    }
}
