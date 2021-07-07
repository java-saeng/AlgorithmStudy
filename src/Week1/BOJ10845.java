package Week1;

//BOJ 10845 큐

import java.util.*;
import java.io.*;

public class BOJ10845 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    static ArrayList<Integer> al = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int test = atoi(st.nextToken());

        while(test-- > 0){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch(str){
                case "push":
                    push(atoi(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop() + "\n");
                    break;
                case "size":
                    sb.append(size() + "\n");
                    break;
                case "empty":
                    sb.append(empty() + "\n");
                    break;
                case "front":
                    sb.append(front() + "\n");
                    break;
                case "back":
                    sb.append(back()+ "\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    static void push(int element){
        al.add(element);
    }

    static int pop(){
        if(al.size() == 0)
            return -1;
        int value = al.get(0);
        al.remove(0);
        return value;
    }

    static int size(){
        return al.size();
    }

    static int empty(){
        if(al.size() == 0)
            return 1;
        else
            return 0;
    }

    static int front(){
        if(al.size() == 0)
            return -1;
        int value = al.get(0);
        return value;
    }

    static int back(){
        if(al.size() == 0)
            return -1;
        int value = al.get(al.size() - 1);
        return value;
    }
}
