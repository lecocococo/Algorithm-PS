import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        String uid = "";
        String name = "";
        int cnt = 0;
        HashMap<String, String> map = new HashMap<>();
        
        for(int i=record.length-1;i>=0;i--){
            String[] temp = record[i].split(" ");
            
            if ( temp.length > 2){
                if (map.containsKey(temp[1])){
                    continue;
                }
                uid = temp[1];
                name = temp[2];
                
                map.put(uid, name);
            }
        }
        
        for(int i=0;i<record.length;i++){
            
            if(record[i].charAt(0)== 'E'){
                answer.add(map.get(record[i].split(" ")[1]) + "님이 들어왔습니다.");
            }
            else if(record[i].charAt(0) == 'L'){
                answer.add(map.get(record[i].split(" ")[1]) + "님이 나갔습니다.");
            }
            
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}
