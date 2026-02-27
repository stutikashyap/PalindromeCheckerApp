import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    // Method 1: Two Pointer Approach
    public static boolean twoPointerCheck(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Method 2: Stack Based
    public static boolean stackCheck(String input) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Method 3: Deque Based
    public static boolean dequeCheck(String input) {

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String input = "racecar";

        long startTime, endTime;

        // Two Pointer Timing
        startTime = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

        // Stack Timing
        startTime = System.nanoTime();
        boolean result2 = stackCheck(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        // Deque Timing
        startTime = System.nanoTime();
        boolean result3 = dequeCheck(input);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        System.out.println("======================================");
        System.out.println("UC13 - Performance Comparison");
        System.out.println("======================================");
        System.out.println("Input: " + input);
        System.out.println();

        System.out.println("Two Pointer Result: " + result1 +
                " | Time: " + twoPointerTime + " ns");

        System.out.println("Stack Result: " + result2 +
                " | Time: " + stackTime + " ns");

        System.out.println("Deque Result: " + result3 +
                " | Time: " + dequeTime + " ns");

        System.out.println("Program executed successfully.");
    }
}