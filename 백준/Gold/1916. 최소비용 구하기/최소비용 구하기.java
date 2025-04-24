import java.util.*;
import java.io.*;

public class Main{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[] visited = new boolean[N+1];
        List<int[]>[] busList = new ArrayList[N+1];
        int start, end, distance;
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());
            
            if (busList[start]==null){
                busList[start] = new ArrayList<>();
            }
            busList[start].add(new int[]{end, distance});
        }
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        int[] dist = new int[N+1];
        for (int i=0; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[start] = 0;
        PriorityQueue<Integer> Q = new PriorityQueue<>((o1, o2) -> {
            return dist[o1]-dist[o2];
        });
        Q.offer(start);
        int current, d;
        while (!Q.isEmpty()){
            current = Q.poll();
            if (visited[current] || busList[current]==null)
                continue;
            visited[current] = true;
            for (int[] bus:busList[current]){
                d = dist[current]+bus[1];
                if (dist[bus[0]]>d){
                    dist[bus[0]] = d;
                    Q.offer(bus[0]);
                }
            }
        }
        
        System.out.println(dist[end]);
    }
}