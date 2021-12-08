import java.io.*;
import java.util.*;

public class Main {
    public static int M;
    public static StringBuilder sb= new StringBuilder("");
    public static int num;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        num = 0;
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "add":
                    add(Integer.parseInt(st.nextToken()) - 1);
                    break;
                case "remove":
                    remove(Integer.parseInt(st.nextToken()) - 1);

                    break;
                case "check":
                    check(Integer.parseInt(st.nextToken()) - 1);
                    break;
                case "toggle":
                    toggle(Integer.parseInt(st.nextToken()) - 1);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }
        System.out.println(sb);
    }
    public static void add(int bit){
        num |= (1<<bit);
//        System.out.println(num);
    }

    public static void remove(int bit){
        num &= ~(1<<bit);
    }

    public static void check(int bit){
        if((num &(1<<bit))>0){
//            System.out.println("1");
            sb.append("1").append("\n");
        }
        else{
//            System.out.println("0");
            sb.append("0").append("\n");
        }
    }

    public static void toggle(int bit){
        num ^= (1<<bit);
    }

    public static void all(){
        num = (1<<20) - 1;

    }
    public static void empty(){
        num = 0;
    }
}
