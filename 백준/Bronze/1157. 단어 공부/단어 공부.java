import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] inputText = br.readLine().strip().toCharArray();
        int[] counter = new int[26];

        for (char c : inputText) {
            int n;
            if (c >= 'a') {
                n = c - 'a';
            } else {
                n = c - 'A';
            }
            counter[n]++;
        }
        int max = 0;
        int maxIdx = 0;
        boolean unknown = false;
        for (int i=0;i<26; i++){
            if (counter[i]>max){
                max = counter[i];
                maxIdx = i;
                unknown = false;
            } else if (counter[i]==max){
                unknown = true;
            }
        }
        System.out.println(unknown?'?':(char)(maxIdx+'A'));
    }
}
