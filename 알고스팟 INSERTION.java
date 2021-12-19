import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    static class TreapNode {
        public static final Random r = new Random();
        public int value;
        public int priority;
        public int size;
        public TreapNode left;
        public TreapNode right;

        public TreapNode(int value, TreapNode left, TreapNode right) {
            super();
            this.value = value;
            this.priority = r.nextInt();
            this.left = left;
            this.right = right;
            this.size = 1;
        }

        public void resetSize() {
            this.size = 1;

            if (this.left != null) {
                size += this.left.size;
            }

            if (this.right != null) {
                size += this.right.size;
            }
        }
    }

    static class NodePair {
        TreapNode low, high;

        public NodePair(TreapNode low, TreapNode high) {
            super();
            this.low = low;
            this.high = high;
        }
    }

    // [0] 은 기준값보다 작은거, [1]은 기준값보다 큰거
    // key는 기준값
    public static NodePair split(int value, TreapNode node) {
        if (node == null) {
            return new NodePair(null, null);
        }

        if (node.value < value) {
            NodePair pair = split(value, node.right);
            node.right = pair.low;
            node.resetSize();
            return new NodePair(node, pair.high);
        }

        NodePair pair = split(value, node.left);
        node.left = pair.high;
        node.resetSize();
        return new NodePair(pair.low, node);
    }

    public static TreapNode insert(TreapNode newNode, TreapNode rootNode) {
        if (rootNode == null) {
            return newNode;
        }

        if (rootNode.priority < newNode.priority) {
            NodePair pair = split(newNode.value, rootNode);
            newNode.left = pair.low;
            newNode.right = pair.high;
            newNode.resetSize();
            return newNode;
        }

        // newNode priority가 작고 (자식이 되고), value가 작으면 왼쪽
        if (newNode.value < rootNode.value) {
            rootNode.left = insert(newNode, rootNode.left);
        } else {
            rootNode.right = insert(newNode, rootNode.right);
        }
        rootNode.resetSize();
        return rootNode;
    }

    public static TreapNode getNIndexNode(int index, TreapNode node) {
        int LSize = node.left != null ? node.left.size : 0;

        if (index == LSize + 1) {
            return node;
        } else if (index <= LSize) {
            return getNIndexNode(index, node.left);
        }

        // else if (index > LSize) {
        return getNIndexNode(index - LSize - 1, node.right);
    }

    public static TreapNode merge(TreapNode lower, TreapNode higher) {
        if (lower == null) {
            return higher;
        }
        if (higher == null) {
            return lower;
        }

        if (lower.priority < higher.priority) {
            higher.left = merge(lower, higher.left);
            higher.resetSize();
            return higher;
        }

        lower.right = merge(lower.right, higher);
        lower.resetSize();
        return lower;
    }

    public static TreapNode delete(TreapNode delNode, TreapNode rootNode) {
        if (rootNode == null) {
            return rootNode;
        }

        if (delNode.value == rootNode.value) {
            rootNode = merge(rootNode.left, rootNode.right);
        } else if (delNode.value < rootNode.value) {
            rootNode.left = delete(delNode, rootNode.left);
            rootNode.resetSize();
        } else if (delNode.value > rootNode.value) {
            rootNode.right = delete(delNode, rootNode.right);
            rootNode.resetSize();
        }
        return rootNode;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < C; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            // create tree
            TreapNode root = null;
            int shift[] = new int[N];
            for (int n = 0; n < N; n++) {
                root = insert(new TreapNode(n + 1, null, null), root);
                shift[n] = Integer.parseInt(st.nextToken());
            }

            // get solution
            int[] sol = new int[N];
            for (int s = N - 1; s >= 0; s--) {
                int ATailValue = shift[s];

                TreapNode node = getNIndexNode(s + 1 - ATailValue, root);
                root = delete(node, root);
                sol[s] = node.value;
            }

            for (int p = 0; p < N; p++) {
                bw.write(String.valueOf(sol[p]));
                bw.write(" ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
