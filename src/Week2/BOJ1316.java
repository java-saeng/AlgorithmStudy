package Week2;

//BOJ 1316 그룹 단어 체커

import java.util.*;
import java.io.*;

public class BOJ1316{
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    static ArrayList<Character> al = new ArrayList<>();
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int size = atoi(st.nextToken());

        for(int i = 0; i < size; i++){
            String str = br.readLine();
            stack = new Stack<>();
            al = new ArrayList<>();

            for(int j = 0; j < str.length(); j++){
                stack.push(str.charAt(j));
            }
            if(isContain()) cnt++;
        }

        System.out.println(cnt);
    }

    static boolean isContain(){
        char value = stack.pop();
        while(!stack.isEmpty()){
            char beforeValue = stack.peek();
            if(beforeValue == value){
                stack.pop();
            }
            else{
                if(al.contains(beforeValue)) return false;
                al.add(value);
                value = stack.pop();
            }
        }
        return true;
    }
}
