import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeService ps = new PalindromeService();
        System.out.print("Input : ");
        String input = scanner.nextLine();
        boolean isPalindrome = ps.checkPalindrome(input);
        System.out.println("Input: " + input);
        System.out.println("is Palindrome? " + isPalindrome);
    }
}
class PalindromeService{
    public boolean checkPalindrome (String input){
        int start = 0;
        int end = input.length()-1;

        while(start<end){
            if(input.charAt(start) != input.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}