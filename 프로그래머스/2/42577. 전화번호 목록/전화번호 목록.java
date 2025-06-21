import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i=0; i<phone_book.length-1; i++){
            if (phone_book[i].length() < phone_book[i+1].length()){
                boolean flag = true;
                for (int j=0; j<phone_book[i].length(); j++){
                    if (phone_book[i].charAt(j)!=phone_book[i+1].charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    return false;
                }
            }
        }
        return true;
    }
}