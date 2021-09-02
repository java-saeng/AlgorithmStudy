package Week8;

import java.util.*;

class 오픈채팅방 {
    public String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();

        for(int i = 0; i < record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String order = st.nextToken();
            if(!order.equals("Leave")){
                hm.put(st.nextToken(), st.nextToken());
            }
        }

        for(int i = 0; i < record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String order = st.nextToken();
            String s1 = st.nextToken();
            if(order.equals("Enter")){
                al.add(hm.get(s1) + "님이 들어왔습니다.");
            }
            else if(order.equals("Leave")){
                al.add(hm.get(s1) + "님이 나갔습니다.");
            }
        }

        String answer[] = al.toArray(new String[al.size()]);

        return answer;
    }
}
