import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        
        int first = Integer.parseInt(st.nextToken());
        int max = first;
        int min = first;
        for (int i = 1; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (k>max){
                max = k;
            } else if (k<min){
                min = k;
            }
        }
        System.out.println(min + " " + max);
    }
}
