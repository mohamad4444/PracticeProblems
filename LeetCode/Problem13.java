

import java.util.HashMap;

class Problem13 {
    
    public static void main(String[] args) {
        Problem13 s=new Problem13();
        System.out.println(s.romanToInt("MDCXCV"));
    }
    public int romanToInt(String s) {
        int result=0;
        HashMap<Character,Integer> romans=new HashMap<>();
        HashMap<String,Integer> romans2=new HashMap<>();
        int len=s.length();
        romans.put('I',1);
        romans.put('V',5);
        romans.put('X',10);
        romans.put('L',50);
        romans.put('C',100);
        romans.put('C',100);
        romans.put('D', 500);
        romans.put('M', 1000);
        romans2.put("IV", 4);
        romans2.put("IX", 9);
        romans2.put("XL", 40);
        romans2.put("XC", 90);
        romans2.put("CD", 400);
        romans2.put("CM", 900);
        for(int i=0;i<len;i++){
            String slice=s.substring(i, i+2>len?i+1:i+2);
            if(romans2.get(slice)!=null){
                result=result+romans2.get(slice);
                i++;
            }else{
                result=result+romans.get(s.charAt(i));
            }
        }

        return result;

    }
    //Internet solution 2ms
    public int romanToInt2(String s) {
        int ans = 0, num = 0;
       for (int i = s.length()-1; i >= 0; i--) {
           switch(s.charAt(i)) {
               case 'I': num = 1; break;
               case 'V': num = 5; break;
               case 'X': num = 10; break;
               case 'L': num = 50; break;
               case 'C': num = 100; break;
               case 'D': num = 500; break;
               case 'M': num = 1000; break;
           }
           if (4 * num < ans) ans -= num;
           else ans += num;
       }
       return ans;
   }
    
}
