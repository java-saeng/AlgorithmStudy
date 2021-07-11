package Week2;

//BOJ 15903 카드 합체 놀이

import java.util.*;
import java.io.*;

public class BOJ15903 {
    static long atoi(String str) {
        return Long.parseLong(str);
    }

    static int acoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int card = acoi(st.nextToken());
        int change = acoi(st.nextToken());

        ArrayList<Long> al = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < card; i++) {
            al.add(atoi(st.nextToken()));
        }

        while (change-- > 0) {
            Collections.sort(al);
            long s1 = al.get(0);
            long s2 = al.get(1);

            long sum = s1 + s2;

            al.set(0, sum);
            al.set(1, sum);
        }

        long result = 0;
        for (long index : al) {
            result += index;
        }

        System.out.print(result);
    }
}

////                                        우선 순위 큐
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int card = acoi(st.nextToken());
//        int change = acoi(st.nextToken());
//
//        Queue<Long> q = new PriorityQueue<>();
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < card; i++) {
//            q.offer(atoi(st.nextToken()));
//        }
//
//        /////////////////////////////////////입력 끝
//
//        //문제에서 이미 n은 2이상이기 떄문에 empty 고려 안해도됨
//        while (change-- > 0) {
//
//            long s1 = q.poll();
//            long s2 = q.poll();
//
//            long sum = s1 + s2;
//
//            q.offer(sum);
//            q.offer(sum);
//
//            long result = 0;
//
//            for (long index : q) {
//                result += index;
//            }
//
//            System.out.print(result);
//        }
//    }
//}
/**
 * 반례
 * 2 30
 * 1000000 1000000
 **/