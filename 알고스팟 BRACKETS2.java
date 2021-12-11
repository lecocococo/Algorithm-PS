import java.io.*;
import java.util.Stack;

public class Main {
    public static int C;
    public static Stack<String> st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());

        for(int z = 0; z<C; z++){
            String[] s = br.readLine().split("");

            st = new Stack<>();
            for(int i = 0; i < s.length;i++){
                String top = "";
                switch (s[i]){
                    case "(","{","[":
                        st.push(s[i]);
                        /*System.out.println(st.peek());*/
                        break;
                    case ")":
                        top = st.pop();
                        if (!top.equals("(")){
                            System.out.println("NO");
                            return;
                        }
                        break;
                    case "}":
                        top = st.pop();
                        if (!top.equals("{")){
                            System.out.println("NO");
                            return;
                        }
                        break;
                    case "]":
                        top = st.pop();
                        if (!top.equals("]")){
                            System.out.println("NO");
                            return;
                        }
                        break;
                }

            }
            if(st.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}
