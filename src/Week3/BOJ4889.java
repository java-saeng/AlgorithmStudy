package Week3;

import java.util.*;
import java.io.*;

public class BOJ4889 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = 0;
        while (true) {
            String str = br.readLine();
            if(str.charAt(0) == '-') break;
            testcase++;
            System.out.println(testcase + "." + " " + getCount(str));
        }
    }

    static int getCount(String str) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '{') stack.push(ch);
            else{
                if (stack.isEmpty()) {
                    ch = '{';
                    stack.push(ch);
                    count++;
                }
                else{
                    stack.pop();
                }
            }
        }
        int result = count + stack.size() / 2;
        return result;
    }
}
