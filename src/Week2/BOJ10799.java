package Week2;

import java.util.*;
import java.io.*;

public class BOJ10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String bar = br.readLine();
        stack.push(bar.charAt(0));
        int result = 0;
        for (int i = 1; i < bar.length(); i++) {
            char ch = bar.charAt(i);
            if(ch == '(') stack.push(ch);
            else{
                stack.pop();
                if(bar.charAt(i-1) == '('){
                    result += stack.size();
                }
                else{
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
