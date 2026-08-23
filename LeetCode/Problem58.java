public class Problem58 {
    public int lengthOfLastWord(String s) {
        int lastindexofSpace=s.trim().lastIndexOf(" ")+1;
        return s.trim().substring(lastindexofSpace).length();
    }
    public static void main(String[] args){
        Problem58 s=new Problem58();
        System.out.println();
        System.out.println();
        System.out.println(s.lengthOfLastWord("hello world haha   "));
    }
}