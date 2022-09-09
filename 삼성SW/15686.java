public class Main {
    static int N;
    static int M;
    static int[][] map;
    private static ArrayList<int[]> vs;
    static HashMap<Integer, ArrayList<int[]>> information;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][N];

        information = new HashMap<>();
        information.put(1,new ArrayList<int[]>());
        information.put(2,new ArrayList<int[]>());
        
        // 집, 치킨집 위치를 기억
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    ArrayList<int[]> arr = information.get(1);
                    arr.add(new int[]{i, j});
                    information.replace(1, arr);
                }

                if (map[i][j] == 2){
                    ArrayList<int[]> arr = information.get(2);
                    arr.add(new int[]{i, j});
                    information.replace(2, arr);
                }
            }
        }

        int s = information.get(2).size();
        boolean[] visited = new boolean[s];
        int r = M;

        answer = Integer.MAX_VALUE;
        combination(information.get(2), visited, 0, s, r);
        System.out.println(answer);
        
    }
    
    // 치킨집 M개 선택하는 메소드
    public static void combination(ArrayList<int[]> arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            ArrayList<int[]> houses = information.get(1);
            vs = val(arr, visited, n);
            int ans = 0;

            for (int[] house : houses) {
                int min = Integer.MAX_VALUE;
                for (int[] chicken : vs) {
                    min = Math.min(min, Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]));
                }
                ans += min;
            }
            answer = Math.min(answer, ans);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }

    }
    
    // 선택된 치킨집을 반환해주는 메소드
    static ArrayList<int[]> val(ArrayList<int[]> arr, boolean[] visited, int n){
        ArrayList<int[]> v = new ArrayList<>();
        for(int i =0;i<n;i++){
            if (visited[i]){
                v.add(arr.get(i));
            }
        }
        return v;
    }
}
