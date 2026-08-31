// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Two-Pointer — O(n) Time, O(1) Space — BEST PRACTICAL / MOST EFFICIENT / INTERVIEW FAVORITE
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}

// RANK 2: For Loop (Index-based Swap) — O(n) Time, O(1) Space — SIMPLEST / CLEAN / MOST EFFICIENT

// class Solution {
//     public void reverseString(char[] s) {

//         for (int i = 0; i < s.length / 2; i++) {
//             char temp = s[i];
//             s[i] = s[s.length - 1 - i];
//             s[s.length - 1 - i] = temp;
//         }
//     }
// }

// RANK 3: Recursion — O(n) Time, O(n) Space — CLEAN / ELEGANT / EXTRA CALL STACK

// class Solution {
//     public void reverseString(char[] s) {
        
//     }
// }

// RANK 4: Using Stack — O(n) Time, O(n) Space — SIMPLE / EXTRA SPACE / LESS EFFICIENT

// import java.util.Stack;

// class Solution {
//     public void reverseString(char[] s) {
//         Stack<Character> stack = new Stack<>();
//         for (char ch : s) {
//             stack.push(ch);
//         }
//         int i = 0;
//         while (!stack.isEmpty()) {
//             s[i] = stack.pop();
//             i++;
//         }
//     }
// }

// RANK 5: Using StringBuilder — O(n) Time, O(n) Space — SIMPLEST SYNTAX / EXTRA SPACE / LEAST PREFERRED
// class Solution {
//     public void reverseString(char[] s) {
//         String reversed = new StringBuilder(new String(s)).reverse().toString();

//         for (int i = 0; i < s.length; i++) {
//             s[i] = reversed.charAt(i);
//         }
//     }
// }

// Driver code to test the Solution class
public class ReverseString {
    public static void main(String[] args) {

        Solution obj = new Solution();

        // Test 1
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        obj.reverseString(s1);
        System.out.println("Reversed: " + new String(s1));   // Reversed: olleh

        // Test 2
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        obj.reverseString(s2);
        System.out.println("Reversed: " + new String(s2));   // Reversed: hannaH

        // Test 3
        char[] s3 = {'a', 'b', 'c', 'd'};
        obj.reverseString(s3);
        System.out.println("Reversed: " + new String(s3));   // Reversed: dcba

        // Test 4
        char[] s4 = {'a'};
        obj.reverseString(s4);
        System.out.println("Reversed: " + new String(s4));   // Reversed: a
    }
}