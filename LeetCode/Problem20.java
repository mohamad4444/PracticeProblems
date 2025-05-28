import java.util.ArrayDeque;
import java.util.Deque;

public class Problem20 {
    public boolean isValid(String s) {
        if (s.length()%2==1){
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            Character cchar=s.charAt(i);
            if(cchar=='('||cchar=='['||cchar=='{'){
                stack.push(getOpposite(cchar));
            }else {
            Character lastInStack=stack.poll();
            if(lastInStack!=cchar){
                return false;
            }
        }
        }
        return stack.size()==0;
    }
    public static char getOpposite(char c) {
        if (c == '[') return ']';
        else if (c == '(') return ')';
        else if (c == '{') return '}';
        else return '\0';
    }
    
    public static void main(String[] args) {
        Problem20 p15=new Problem20();
        System.err.println("\n"+p15.isValid("(("));
    }
    
}
