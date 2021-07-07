package Week1;

//BOJ 1874 스택 수열

/**
 * 저번에 풀어봤던 문제라 어렵진 않았다.
 * 저번 풀이에는 출력할 때 empty 메소드를 사용했지만, 이번에는 다른 방법이 생각났다.
 * 풀면서 숫자 하나를 빼는데 연산은 당연하게 push, pop 두 연산을 사용한다.
 * 그렇다면 수열을 완벽하게 만들었다면 모든 숫자를 stack에서 뺐다는 말이므로 총 size * 2번의 연산을 사용한 것이다.
 * 그래서 2 * size만큼 연산을 사용하면 sb를 출력하고, 아니면 NO를 출력한다.
 */

import java.io.*;
import java.util.*;

public class BOJ1874 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int size = atoi(st.nextToken());
        int arr[] = new int[size];
        int pos = 0;
        int count = 0;
        for(int i = 0; i < size; i++){
            arr[i] = atoi(br.readLine());
        }

        for(int i = 1; i <= size; i++){
            stack.push(i);
            sb.append("+" + "\n");
            count++;
            while(stack.peek() == arr[pos]){
                pos++;
                stack.pop();
                sb.append("-" + "\n");
                count++;
                if(stack.isEmpty()) break;
            }
        }
        if(count == 2 * size)
            System.out.print(sb);
        else
            System.out.print("NO");

//        if(stack.isEmpty())
//            System.out.print(sb);
//        else
//            System.out.print("NO");
    }
}
