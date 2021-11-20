import java.io.*;
import java.util.*;
public class Main {

//  1748번
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int num = 10;
        int digit = 1;
        for(int i = 1; i<=n;i++){
            if(i % num == 0){
                num *= 10;
                digit += 1;
            }
            result += digit;
        }
        System.out.println(result);

    }

}
