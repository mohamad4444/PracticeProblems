public class Problem67 {
    public String addBinary(String a, String b) {
        char[] array1=a.toCharArray();
        char[] array2=b.toCharArray(); 
        
        String result;
        int shortest=Math.min(a.length(), b.length())-1;
        char carry=1;
        System.out.println();
        System.out.println((('1'+'1'+'1'))%2);
        int longest=Math.max(a.length(), b.length())-1;
        for(int i=shortest;i>0;i++){
            

        }
        return ""+array1[0]+array2[0];
            // for(int i=0;i<shortest;i++){
            //     result=""+array1[]
            // }
            

    } // 144 145 146  147
    
    public static void main(String[] args) {
        Problem67 s=new Problem67();
        System.out.println(s.addBinary("11", "1"));

    }
}
