package Week2;

import java.util.*;
import java.io.*;

public class BOJ5525 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = atoi(br.readLine());
        int size = atoi(br.readLine());
        String str = br.readLine();

        char ch[] = new char[size + 1];
        for (int i = 0; i < size; i++) {
            ch[i] = str.charAt(i);
        }

        int result = 0;
        for (int i = 1; i < ch.length; i++) {
            int cnt = 0;
            /*cnt를 왜 초기화할까?
            연속된 IOI의 개수를 구해야하기 때문에
            IOI가 연속되다가 중간에 끊기면 당연히 초기화해야함*/

            if (ch[i - 1] == 'I') {
                while (ch[i] == 'O' && ch[i + 1] == 'I') {
                    /*if조건에 ch[i] == O 하고 while조건에 ch[i-1]에 I를 넣어봤는데 되지 않았다
                    왜? I를 찾고 OI만 찾으면 되기 떄문이다.
                    우리는 IOI를 찾고나서 그 이후에는 반복되는 것이
                    OI이기 떄문이다 ex) IOIOI --> I OIOI*/
                    i += 2;
                    //IOI에서 첫 번째 I를 찾게 되면 당연히 연속된지 확인하기
                    //위해서는 해당 index에서 두 번째 떨어져있는 index를 확인해야함.
                    cnt++;
                    if (cnt == p) {
                        //그림에서 보다시피 cnt는 IOI의 반복횟수를 나타낸다. 그래서
                        //반복횟수가 문제에서 주어진 횟수와 같아지면 한개를 빼야함.

                        cnt--;
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}