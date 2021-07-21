package Week3;

import java.util.*;
import java.io.*;

public class BOJ17413 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length();) {
            boolean flag = false;
            if(str.charAt(i) == '<'){
                while(str.charAt(i) != '>'){
                    sb.append(str.charAt(i));
                    i++;
                }
                sb.append(str.charAt(i++));
                continue;
            }

            else{
                while(i < str.length() && str.charAt(i) != '<'){
                    char ch = str.charAt(i);

                    if(ch == ' '){
                        flag = true;
                        i++;
                        break;
                    }
                    else{
                        stack.push(ch);
                        i++;
                    }
                }
            }

            while (!stack.isEmpty()) {
                char ch = stack.pop();
                 sb.append(ch);
            }
            if(flag) sb.append(" ");
        }

        System.out.println(sb);

    }
}
