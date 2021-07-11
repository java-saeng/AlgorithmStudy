package Week2;

import java.util.*;
import java.io.*;

public class BOJ3005 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    static char arr[][];
    static ArrayList<String> al = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = atoi(st.nextToken());
        int col = atoi(st.nextToken());

        arr = new char[row][col];

        for(int i = 0; i < row; i++){
            String str = br.readLine();
            addString(str); //가로로 만들어지는 문자열
            for(int j = 0; j < col; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < col; i++){
            String str2 = "";
            for(int j = 0; j < row; j++){
                str2 += String.valueOf(arr[j][i]); //세로로 만들어지는 문자열
            }
            addString(str2);
        }

        Collections.sort(al, (o1, o2) -> {
            return o1.compareTo(o2);
        });

        System.out.print(al.get(0));

    }
    static void addString(String str){
        StringTokenizer st = new StringTokenizer(str, "#");

        while (st.hasMoreTokens()) {
            String str2 = st.nextToken();
            if(str2.length() == 1)
                continue;
            else
                al.add(str2);
        }
    }
}
