
import java.util.ArrayList;
import java.util.LinkedList;

class Problem03 {
    public int lengthOfLongestSubstring(String s) {
        if( s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        ArrayList<Character> maxSubstring = new ArrayList<>();
        ArrayList<Character> tempSubstring = new ArrayList<>();
        maxSubstring.add(chars[0]);
        tempSubstring.add(chars[0]);
        int maxSubstringCounter=0;
        char prevChar=chars[0];
        for (int i = 1; i < chars.length; i++) {
            if(maxSubstring.size()<tempSubstring.size()){
                maxSubstring=new ArrayList<>(tempSubstring);
            }
            if(chars[i]!=prevChar && chars[i]!=tempSubstring.get(maxSubstringCounter) &&!tempSubstring.contains(chars[i])){
                prevChar=chars[i];
                tempSubstring.add(chars[i]);
            }else if(chars[i]!=prevChar && chars[i]==tempSubstring.get(maxSubstringCounter)){
                boolean flag=false;
                while(i<chars.length && maxSubstringCounter<tempSubstring.size()&& chars[i]==tempSubstring.get(maxSubstringCounter)){
                    maxSubstringCounter++;
                    i++;
                    flag=true;
                }
                if (flag==true){
                    i--;
                    maxSubstringCounter=0;
                }

            }else if(chars[i]==prevChar){
                tempSubstring=new ArrayList<>();
                tempSubstring.add(chars[i]);
            }else if(tempSubstring.contains(chars[i])){
                ArrayList<Character> tempSubstring2=new ArrayList<>();
                for( int j=tempSubstring.indexOf(chars[i])+1;j<tempSubstring.size();j++){
                    tempSubstring2.add(tempSubstring.get(j));
                }
                tempSubstring=tempSubstring2;
                tempSubstring.add(chars[i]);
            }

        }
        if(maxSubstring.size()<tempSubstring.size()){
            maxSubstring=new ArrayList<>(tempSubstring);
        }
        return maxSubstring.size();
    }

    public static void main(String[] args) {
        Problem03 s = new Problem03();
        int result = s.lengthOfLongestSubstring("bpfbhmipx");
        System.out.println(result);
    }
}