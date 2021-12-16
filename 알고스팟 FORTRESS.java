import java.io.*;
import java.util.Collections;
class TreeNode{
    ArrayList<TreeNode> child = new ArrayList<>();
}
public class Main {

    public static int C;
    public static int N;
    public static int[] x = new int[100];
    public static int[] y = new int[100];
    public static int[] radius = new int[100];
    public static int longest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        for(int z = 0; z <C ;z++){
            N  = Integer.parseInt(br.readLine());
            for(int i = 0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
                radius[i] = Integer.parseInt(st.nextToken());
            }
            TreeNode root = getTreeNode(0);
            longest = 0;
            int h = height(root);
            System.out.println(Math.max(longest, h));
        }
    }
    public static int height(TreeNode root){
        ArrayList<Integer> heights = new ArrayList<>();
        // 각 자식을 루트로 하는 서브트리의 높이 계산
        for(int i = 0;i<root.child.size();i++){
            heights.add(height(root.child.get(i)));
        }
        if(heights.isEmpty()) return 0;
        Collections.sort(heights);
        if(heights.size()>=2){
            // 가장긴 서브트리 높이 2개 선택해서 더해줌
            longest = Math.max(longest, 2 + heights.get(heights.size() - 2) + heights.get(heights.size() - 1));

        }
        // 서브트리 높이 항상 최대로 갱신
        return heights.get(heights.size()-1) + 1;
    }
    public static TreeNode getTreeNode(int root){
        TreeNode ret = new TreeNode();
        for(int ch = 0;ch < N;ch++){
            if(isChild(root,ch)){
                ret.child.add(getTreeNode(ch));
            }
        }
        return ret;
    }
    public static int sqr(int x){
        return x*x;
    }
    public static int sqrDist(int a, int b){
        return sqr(y[a] - y[b]) + sqr(x[a] - x[b]);
    }
    public static boolean enclose(int a, int b){
        // 두점 간의 거리가 반지름 차이보다 작아야함(외접, 내접 검색)
        return radius[a] > radius[b] && sqrDist(a,b) < sqr(radius[a] - radius[b]);
    }

    public static boolean isChild(int parent, int child){
        if(!enclose(parent, child)) return false;
        for(int i = 0;i<N;i++){
            // 중간에 다른 원이 있다면 그건 바로 아래 계층의 원이 아니다.
            if(i != parent && i!= child && enclose(parent, i) && enclose(i, child))
                return false;
        }
        return true;
    }
}
