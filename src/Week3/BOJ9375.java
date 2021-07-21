package Week3;

import java.util.*;
import java.io.*;

public class BOJ9375 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<String, Integer> map;

        int tc = atoi(br.readLine());
        while (tc-- > 0) {
            int size = atoi(br.readLine());
            int result = 1;
            map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 앞에꺼는 필요없어서
                String str = st.nextToken();
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                }
                else{
                    map.put(str, 1);
                }
            }
            for (int idx : map.values()) {
                result *= (idx + 1);
            }
            System.out.println(result - 1);
        }
    }
}