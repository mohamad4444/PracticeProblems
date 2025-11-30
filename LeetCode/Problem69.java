public class Problem69 {
        public int mySqrt(int x) {
            int result=0;
            int high=x,low=0;
            int mid=(high/2+low/2);
            if(x==1){
                return 1;
            }
            while(high-low>1){
                if(mid>x/mid){
                    high=mid;
                    mid=(high/2+low/2+(high%2+low%2)/2);
                }else{
                    low=mid;
                    mid=(high/2+low/2+(high%2+low%2)/2);
                }
            }
            if(high*high==x){
                return high;
            }else if(low*low==x){
                return low;
            }else {
                return low;
            }
        }
    public static void main(String[] args) {
        Problem69 problem69=new Problem69();
        System.out.println();
        System.out.println(problem69.mySqrt(3));
    }
}
