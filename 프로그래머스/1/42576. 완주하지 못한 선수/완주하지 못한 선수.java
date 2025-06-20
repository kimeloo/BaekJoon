import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant){
            if (!map.containsKey(p)){
                map.put(p, 0);
            }
            map.put(p, map.get(p)+1);
        }
        for (String p : completion){
            if (map.get(p)==1){
                map.remove(p);
            }
            else{
                map.put(p, map.get(p)-1);
            }
        }
        for (String p : map.keySet()){
            return p;
        }
        return null;
    }
}