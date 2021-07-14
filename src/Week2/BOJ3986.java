package Week2;

import java.util.*;
import java.io.*;

public class BOJ3986 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = atoi(br.readLine());
        int cnt = 0;
        Stack<Character> stack;
        while (test-- > 0) {
            String str = br.readLine();
            stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!stack.isEmpty()) {
                    if (stack.peek() == ch) {
                        stack.pop();
                    }
                    else{
                        stack.push(ch);
                    }
                }
                else{
                    stack.push(ch);
                }
            }
            if(stack.isEmpty()) cnt++;
        }

        System.out.println(cnt);
    }
}
