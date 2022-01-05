// 알고스팟 단어 제한 끝말잇기(WORDCHAIN)
// 오일러 순회와 경로문제
// dfs
import java.io.*;
import java.util.*;

public class Main {
    public static int C;
    public static boolean[] visit;
    public static int[][] adjacent;
    public static String[] words;
    // graph[i][j] = i에서 시작해서 j로 끝나는단어
    public static ArrayList[][] graph;
    public static int[] indegree;
    public static int[] outdegree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C=Integer.parseInt(br.readLine());

        for(int c = 0;c<C;c++){
            int n = Integer.parseInt(br.readLine());
            words = new String[n];

            graph = new ArrayList[26][26];
            for(int i=0;i<26;i++){
                for(int j =0;j<26;j++){
                    graph[i][j] = new ArrayList();
                }
            }


            indegree = new int[26];
            outdegree = new int[26];
            for(int k=0;k<n;k++) {
                words[k] = br.readLine();
            }
            String result = solve(words);
            System.out.println(result);
        }
    }

    public static void makeGraph(String[] words){
        adjacent = new int[26][26];

        for(int i =0;i< words.length;i++){
            int a = words[i].charAt(0) - 'a';
            int b = words[i].charAt(words[i].length() - 1) - 'a';
//            graph[a][b].add(words[i]);
            graph[a][b].add(words[i]);
            adjacent[a][b]++;
            indegree[b]++;
            outdegree[a]++;
        }
    }
    public static void dfs(int here, ArrayList<Integer> circuit){
        for(int there=0;there< adjacent.length;++there){
            while(adjacent[here][there]>0){
                adjacent[here][there]--; //간선 삭제
                dfs(there,circuit);
            }
        }
        circuit.add(here);
    }
    public static ArrayList<Integer> euilerCircuit(){
        ArrayList<Integer> circuit = new ArrayList<>();
        // 경로인 경우
        for(int i =0;i<26;i++){
            if(outdegree[i] == indegree[i]+1){
                dfs(i, circuit);
                return circuit;
            }
        }

        //순환인경우 아무 간선에서 시작
        for(int i =0;i<26;i++){
            if(outdegree[i]==1){
                dfs(i, circuit);
                return circuit;
            }
        }
        return circuit;
    }

    public static boolean checkEuiler(){
        // 예비 시작점과 끝점의 수
        int plus = 0; int minus = 0;
        for(int i=0;i<26;i++){
            int dif = outdegree[i] - indegree[i];
            if(dif<-1||dif>1) return false;
            if(dif == 1) plus++;
            if(dif == -1)minus++;
        }
        // 한개씩이면 경로가 있는거고 하나도 없다면 순회가 있다는것
        return (plus==1 && minus==1) || (plus==0 && minus==0);
    }

    public static String solve(String[] words){
        makeGraph(words);

        if(!checkEuiler()) return "IMPOSSIBLE";

        ArrayList<Integer> circuit = euilerCircuit();
        if(circuit.size() != words.length + 1){
            return "IMPOSSIBLE";
        }

        Collections.reverse(circuit);

        String result = "";
        for(int i = 1;i<circuit.size();i++){
            int a = circuit.get(i-1);
            int b = circuit.get(i);
            if(result.length()>0) result += " ";
            result += graph[a][b].get(graph[a][b].size() - 1);
            graph[a][b].remove(graph[a][b].size() - 1);
        }
        return result;
    }

}
