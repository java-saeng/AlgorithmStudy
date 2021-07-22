package Week3;

//BOJ 2841 외계인의 기타 연주

import java.util.*;
import java.io.*;

public class BOJ2841 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static Stack<Integer> stack[] = new Stack[7];
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 7; i++) {
            stack[i] = new Stack<>();
        }

        int tc = atoi(st.nextToken());
        int max = atoi(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int index = atoi(st.nextToken());
            int element = atoi(st.nextToken());
            pushStack(index, element);
        }

        System.out.println(cnt);
    }

    static void pushStack(int index, int element) {

        while (!stack[index].isEmpty()) {
            if(stack[index].peek() <= element) break;

            stack[index].pop();
            cnt++;
        }

        if (stack[index].isEmpty() || stack[index].peek() != element) {
            stack[index].push(element);
            cnt++;
        }


        /*if(stack[index].isEmpty()) {
            stack[index].push(element);
            cnt++;
        }
        else{
            if(stack[index].peek() < element){
                stack[index].push(element);
                cnt++;
            }
            else if (stack[index].peek() > element) {
                while (!stack[index].isEmpty() && stack[index].peek() > element) {
                    stack[index].pop();
                    cnt++;
                }
                if (stack[index].isEmpty()) {
                    stack[index].push(element);
                    cnt++;
                }
                else if (!stack[index].isEmpty() && stack[index].peek() != element) {
                    stack[index].push(element);
                    cnt++;
                }
            }
        }*/
    }
}
