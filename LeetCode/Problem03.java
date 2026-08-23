
import java.util.HashMap;

class Problem03 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!lastSeen.containsKey(chars[i])) {
                lastSeen.put(chars[i], i);
            }else{
                int currLength=i-lastSeen.get(chars[i]);
                if(currLength>maxLength){
                    maxLength=currLength;
                }
                lastSeen.put(chars[i], i);
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        Problem03 s = new Problem03();
        System.out.println();
        int result = s.lengthOfLongestSubstring("bpoiexpqhmebhhu");
        System.out.println(result);
    }
}
