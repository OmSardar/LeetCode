// ============================ FINAL DESTINATION ============================

// RANK 1: Reverse Traversal — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT
class Solution {
    public int lengthOfLastWord(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        int i = arr.length - 1;
        while (i >= 0 && arr[i] == ' ') {
            i--;
        }
        while (i >= 0 && arr[i] != ' ') {
            count++;
            i--;
        }
        return count;
    }
}

// RANK 2: Trim + Split — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public int lengthOfLastWord(String s) {
//
//         String[] words = s.trim().split(" ");
//
//         return words[words.length - 1].length();
//     }
// }


// RANK 3: StringBuilder Reverse Traversal — O(n) TIME, O(n) SPACE — SIMPLE / GOOD ALTERNATIVE
// class Solution {
//     public int lengthOfLastWord(String s) {
//
//         StringBuilder sb = new StringBuilder(s.trim());
//
//         int count = 0;
//
//         for (int i = sb.length() - 1; i >= 0; i--) {
//
//             if (sb.charAt(i) == ' ') {
//                 break;
//             }
//
//             count++;
//         }
//
//         return count;
//     }
// }


// RANK 4: Regular Expression (split) — O(n) TIME, O(n) SPACE — CONCISE / LEAST PRACTICAL
// class Solution {
//     public int lengthOfLastWord(String s) {
//
//         String[] words = s.trim().split("\\s+");
//
//         return words[words.length - 1].length();
//     }
// }


// Driver code to test the Solution class
public class LengthOfLastWord {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Normal sentence
        String s1 = "Hello World";
        System.out.println(
                "Test Case 1: " + solution.lengthOfLastWord(s1)); // Answer: 5

        // Test Case 2: Trailing spaces
        String s2 = "   fly me   to   the moon  ";
        System.out.println(
                "Test Case 2: " + solution.lengthOfLastWord(s2)); // Answer: 4

        // Test Case 3: Multiple words
        String s3 = "luffy is still joyboy";
        System.out.println(
                "Test Case 3: " + solution.lengthOfLastWord(s3)); // Answer: 6

        // Test Case 4: Single word
        String s4 = "Hello";
        System.out.println(
                "Test Case 4: " + solution.lengthOfLastWord(s4)); // Answer: 5

        // Test Case 5: Leading spaces
        String s5 = "   Hello";
        System.out.println(
                "Test Case 5: " + solution.lengthOfLastWord(s5)); // Answer: 5

        // Test Case 6: One-letter last word
        String s6 = "Hello W";
        System.out.println(
                "Test Case 6: " + solution.lengthOfLastWord(s6)); // Answer: 1

        // Test Case 7: Multiple trailing spaces
        String s7 = "Today is a good day     ";
        System.out.println(
                "Test Case 7: " + solution.lengthOfLastWord(s7)); // Answer: 3

        // Test Case 8: Last word after many spaces
        String s8 = "The quick brown fox jumps over";
        System.out.println(
                "Test Case 8: " + solution.lengthOfLastWord(s8)); // Answer: 4
    }
}