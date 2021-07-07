package Week1;

//BOJ 1406 에디터

import java.io.*;
import java.util.*;

public class BOJ1406 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> leftstack = new Stack<>();
        Stack<Character> rightstack = new Stack<>();
        String str = br.readLine();

        int test = atoi(br.readLine());

        for(int i = 0; i < str.length(); i++){
            leftstack.push(str.charAt(i));
        }

        while(test-- > 0){
            String order = br.readLine();
            switch(order.charAt(0)){
                case 'P':
                    leftstack.push(order.charAt(2));
                    break;
                case 'L':
                    if(!leftstack.isEmpty())
                        rightstack.push(leftstack.pop());
                    break;
                case 'D':
                    if(!rightstack.isEmpty())
                        leftstack.push(rightstack.pop());
                    break;
                case 'B':
                    if(!leftstack.isEmpty())
                        leftstack.pop();
                    break;
            }
        }
        while(!leftstack.isEmpty())
            rightstack.push(leftstack.pop());

        while(!rightstack.isEmpty())
            sb.append(rightstack.pop());

        System.out.print(sb);
    }
}
