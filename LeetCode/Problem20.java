import java.util.ArrayDeque;
import java.util.Deque;

public class Problem20 {
    public boolean isValid(String s) {
        if (s.length()%2==1){
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(char cchar:s.toCharArray()){
            if(cchar=='('){
                stack.push(')');
            }else if(cchar=='[') {
                stack.push(']');
            }else if(cchar=='{'){
                stack.push('}');
            }else if (stack.isEmpty() ||stack.poll()!=cchar){
                return false;
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        Problem20 p15=new Problem20();
        System.err.println("\n"+p15.isValid("){"));
    }
    
}
