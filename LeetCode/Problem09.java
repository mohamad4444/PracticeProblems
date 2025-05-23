
class Problem09 {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }else if(x<10){
            return true;
        }else{
            int originalNumber = x;
            int reversedNumer=0;
            while (x>0) {
                int rightSide=x%10;
                reversedNumer=reversedNumer*10+rightSide;
                x=x/10;
            }
            return (originalNumber==reversedNumer);
        }        
    }
    public static void main(String[] args) {
        Problem09 solution=new Problem09();
        System.out.println();
        System.out.println(solution.isPalindrome(101));

        System.out.println(16<<2);
    }
}