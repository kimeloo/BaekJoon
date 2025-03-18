import java.lang.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().strip();
        int len, cnt, sum;
        
        cnt = 0;
        while (str.length()>1){
            sum = 0;
            for (int i=0; i<str.length(); i++){
                sum += str.charAt(i)-'0';
            }
            str = ""+sum;
            cnt++;
        }
        System.out.println(cnt);
        if ((str.charAt(0)-'0')%3==0){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
        
        br.close();
    }
}