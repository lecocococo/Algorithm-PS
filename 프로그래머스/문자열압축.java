import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        if (s.length() == 1){
            answer = 1;
            // return answer = 1;
        }
        for(int i=1;i<s.length()/2 + 1;i++){
            String substr = s.substring(0, i);
            int sublen = substr.length();
            int cnt = 1;
            int len = 0;
            
            
            for(int j=i;j<s.length();j+=i){
                if(j+i> s.length()){
                    // last = s.substring(j).length();
                    continue;
                }
                    
                
                if (substr.equals(s.substring(j, j + i))){
                    cnt++;
                }
                else{
                    len += sublen;
                    if(cnt > 1){
                        len += String.valueOf(cnt).length();
                    }
                    substr = s.substring(j, j + i);
                    cnt = 1;
                }
                
            }
            
            len += sublen + s.length() % i; 
            if(cnt > 1){
                len += String.valueOf(cnt).length();
            }
            answer = Math.min(answer, len);
            
            
        }
        return answer;
    }
}
