import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->{
            if (o1[1]==o2[1]){
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o2[1], o1[1]);
        });
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] meeting;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            meeting = new int[2];
            meeting[0] = Integer.parseInt(st.nextToken());
            meeting[1] = Integer.parseInt(st.nextToken());
            q.offer(meeting);
        }
        
        int start, end, cnt;
        meeting = q.poll();
        start = meeting[0];
        end = meeting[1];
        //System.out.println(start+" "+end);
        cnt = 1;
        while (!q.isEmpty()){
            meeting = q.poll();
            //System.out.println(meeting[0]+" "+meeting[1]);
            if (meeting[1]<=end && meeting[0]>start){
                if (meeting[0]==end){
                    cnt++;
                }
                end = meeting[1];
                start = meeting[0];
            }
            else if (meeting[1]<=start){
                cnt++;
                end = meeting[1];
                start = meeting[0];
            }
        }
        System.out.println(cnt);
        
        br.close();
    }
}