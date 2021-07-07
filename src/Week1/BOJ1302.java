package Week1;

//BOJ 1302 베스트셀러

import java.io.*;
import java.util.*;

public class BOJ1302 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        int size = atoi(st.nextToken());

        for(int i = 0; i < size; i++){
            String str = br.readLine();

            if(map.containsKey(str)) {
                int value = map.get(str);
                value++;
                map.put(str, value);
            }
            else{
                map.put(str, 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> {
            if(o2.getValue() != o1.getValue())
                return o2.getValue() - o1.getValue();
            else
                return o1.getKey().compareTo(o2.getKey());
        });

        System.out.print(list.get(0).getKey());
    }
}
