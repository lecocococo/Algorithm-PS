import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // heap에 값넣기
//    public static void pushHeap(ArrayList<Integer> heap, int value){
//        heap.add(value);
//        int idx = heap.size() - 1;
//        while(idx>0 && heap.get((idx-1)/2) <heap.get(idx)){
//            //swap
//            int temp = heap.get((idx-1)/2);
//            heap.set((idx-1)/2, heap.get(idx));
//            heap.set(idx, temp);
//
//            idx = (idx-1)/2;
//        }
//    }
    // heap에서 최대값(root)삭제하기
//    public static int removeTop(ArrayList<Integer> heap){
//        int result = heap.get(0);
//        heap.set(0, heap.get(heap.size() - 1));
//        int here = 0;
//        while(true){
//            int left = here*2 + 1;
//            int right = here*2 + 2;
//            if(left>= heap.size()) break;
//            int next = here;
//            if(heap.get(next)<heap.get(left)){
//                next = left;
//            }
//            if(right< heap.size() && heap.get(next)<heap.get(right)){
//                next = right;
//            }
//            if(next == here) break;
//            int temp = heap.get(here);
//            heap.set(here, heap.get(next));
//            heap.set(next, temp);
//
//            here = next;
//        }
//        return result;
//    }

    public static ArrayList<Long> makeArray(int N, int a,int b){
        ArrayList<Long> arr = new ArrayList<>();
        arr.add((long)1983);
        for(int i = 1;i<N;i++){
            arr.add((arr.get(i-1)*a+b)%20090711);
        }
        return arr;
    }

    public static int C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        C = Integer.parseInt(br.readLine());
        for(int c=0;c<C;c++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ArrayList<Long> arr = makeArray(N, a, b);
//            for(long num:arr){
//                System.out.println(num);
//            }
            long result = getMedian(N, arr);
//            System.out.println(result);
            bw.write(String.valueOf(result)); // 출력시 String으로 바꾸어 줘야함
            bw.flush();
        }
        br.close();
        bw.close();
    }

    // O(nlogn)복잡도
    public static long getMedian(int n, ArrayList<Long> arr){
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long result = 0;
        // 최대힙은 최소힙과 크기가 같거나 1더크다
        // 최대힙의 최대값은 최소힙의 최소값보다 작아야한다.
        for(int cnt = 1;cnt<=n;cnt++){
            // 최대힙은 최소힙과 크기가 같거나 1더크다
            if(maxHeap.size() == minHeap.size()){
                maxHeap.add(arr.get(cnt-1));
            }
            else{
                minHeap.add(arr.get(cnt - 1));
            }

            // 최대힙의 최대값은 최소힙의 최소값보다 작아야한다.
            if(!maxHeap.isEmpty() && !minHeap.isEmpty() && minHeap.peek()<maxHeap.peek()){
                long a = maxHeap.poll();
                long b = minHeap.poll();
                maxHeap.add(b);
                minHeap.add(a);
            }
            // 최대힙의 최대값은 항상 중간값이다.
            result = (result + maxHeap.peek()) % 20090711;
        }
        return result;
    }
}
