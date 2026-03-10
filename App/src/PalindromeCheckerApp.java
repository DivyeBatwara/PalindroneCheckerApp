import java.util.Scanner;
import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string for benchmarking: ");
        String input = scanner.nextLine();

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy twoPointerStrategy = new TwoPointerStrategy();

        System.out.println("\n--- UC13: Performance Comparison ---");

        long startTimeStack = System.nanoTime();
        boolean res1 = stackStrategy.check(input);
        long endTimeStack = System.nanoTime();
        long durationStack = endTimeStack - startTimeStack;

        long startTimeTP = System.nanoTime();
        boolean res2 = twoPointerStrategy.check(input);
        long endTimeTP = System.nanoTime();
        long durationTP = endTimeTP - startTimeTP;

        System.out.println("1. Stack Strategy       | Result: " + res1 + " | Time: " + durationStack + " ns");
        System.out.println("2. Two-Pointer Strategy | Result: " + res2 + " | Time: " + durationTP + " ns");

        System.out.println("\nPerformance Gap: " + (durationStack - durationTP) + " ns");

        scanner.close();
    }
}
interface PalindromeStrategy {
    boolean check(String input);
}
class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String str = input.toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}
class TwoPointerStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String str = input.toLowerCase();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
}