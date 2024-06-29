package CodeWars;


public class PangramChecker {

    public boolean check(String sentence) {
        char[] arr = sentence.toCharArray();
        int[] alphabet = new int[26];
        for (int i = 0; i < arr.length; i++) {
            if (97 <= arr[i] && arr[i] <= 122) {
                alphabet[arr[i] - 97] = 1;
            } else if (65 <= arr[i] && arr[i] <= 90) {
                alphabet[arr[i] - 65] = 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] != 1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println();
        System.out.println(0 + 'A');
        System.out.println(0 + 'Z');
        System.out.println('A');
        System.out.println('A');

    }
}
