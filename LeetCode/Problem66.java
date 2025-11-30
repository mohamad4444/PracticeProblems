public class Problem66 {
    public int[] plusOne(int[] digits) {
        int[] results=new int[digits.length+1];
        int carry=0;
        boolean firstEntrance=true;
        int counter=digits.length-1;
        while(carry!=0||firstEntrance){
            firstEntrance=false;
            digits[counter]=digits[counter]+carry+1;
            carry=digits[counter]/10;
            digits[counter]=digits[counter]%10;
            counter--;
            if(counter==-1){
                break;
            }
        }
        if(carry>0){
            results[0]=carry;
            for(int i=1;i<results.length;i++){
                results[i]=digits[i-1];
            }
            return results;
        }
        return digits;
    }
    public static void main(String[] args) {
        Problem66 p66=new Problem66();
        p66.plusOne(new int[]{9,9});
    }
}