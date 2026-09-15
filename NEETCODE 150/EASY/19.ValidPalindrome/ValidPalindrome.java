// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Two-Pointer Method — O(n), O(n) — BEST / MOST EFFICIENT
class Solution {
    public boolean isPalindrome(String s) {

        String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}


// RANK 2: Reverse String and Compare — O(n), O(n)
// class Solution {
//     public boolean isPalindrome(String s) {
//         String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//         String rev = new StringBuilder(str).reverse().toString();
//         return str.equals(rev);
//     }
// }


// RANK 3: Manual Reverse Using Char Array — O(n), O(n)
// class Solution {
//     public boolean isPalindrome(String s) {
//         String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//         char[] arr = str.toCharArray();
//         char[] rev = new char[arr.length];
//
//         for (int i = 0; i < arr.length; i++) {
//             rev[i] = arr[arr.length - 1 - i];
//         }
//
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] != rev[i]) return false;
//         }
//
//         return true;
//     }
// }


// RANK 4: Recursion Method — O(n), O(n) — EXTRA STACK SPACE
// class Solution {
//     public boolean isPalindrome(String s) {
//         String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//         return helper(str, 0, str.length() - 1);
//     }
//
//     private boolean helper(String s, int left, int right) {
//         if (left >= right) return true;
//         if (s.charAt(left) != s.charAt(right)) return false;
//         return helper(s, left + 1, right - 1);
//     }
// }


// RANK 5: Stack & Queue (Data Structure Approach) — O(n), O(n) — WORST / NOT RECOMMENDED
// import java.util.*;
// class Solution {
//     public boolean isPalindrome(String s) {
//
//         String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//
//         Stack<Character> stack = new Stack<>();
//         Queue<Character> queue = new LinkedList<>();
//
//         for (char c : str.toCharArray()) {
//             stack.push(c);
//             queue.add(c);
//         }
//
//         while (!stack.isEmpty()) {
//             if (!stack.pop().equals(queue.remove())) {
//                 return false;
//             }
//         }
//
//         return true;
//     }
// }


// Driver code to test the Solution class
public class ValidPalindrome {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String[] testCases = {
            "A man, a plan, a canal: Panama",  // Output: true
            "race a car",                      // Output: false
            " "                                // Output: true
        };

        for (String s : testCases) {
            System.out.println("Input: " + s);
            System.out.println("Output: " + solution.isPalindrome(s));
            System.out.println();
        }
    }
}