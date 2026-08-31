// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Two Pointers — O(n) Time, O(1) Space — MOST EFFICIENT / BEST PRACTICAL / INTERVIEW FAVORITE
class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

// RANK 2: Recursion with Deletion Flag — O(n) Time, O(n) Space — EFFICIENT / CLEAN / EXTRA CALL STACK
// class Solution {
//     public boolean validPalindrome(String s) {
//         if (isPalindrome(s)) return true;

//         for (int i = 0; i < s.length(); i++) {
//             String t = s.substring(0, i) + s.substring(i + 1);
//             if (isPalindrome(t)) return true;
//         }
//         return false;
//     }

//     private boolean isPalindrome(String s) {
//         int l = 0, r = s.length() - 1;
//         while (l < r) {
//             if (s.charAt(l++) != s.charAt(r--)) return false;
//         }
//         return true;
//     }
// }


// RANK 3: Stack-Based Check (Educational) — O(n) Time, O(1) Space — SIMPLE / GOOD FOR LEARNING / REDUNDANT
// class Solution {
//     public boolean validPalindrome(String s) {
//         int l = 0, r = s.length() - 1;

//         while (l < r) {
//             if (s.charAt(l) != s.charAt(r)) {
//                 return check(s, l + 1, r) || check(s, l, r - 1);
//             }
//             l++;
//             r--;
//         }
//         return true;
//     }

//     private boolean check(String s, int l, int r) {
//         while (l < r) {
//             if (s.charAt(l++) != s.charAt(r--)) return false;
//         }
//         return true;
//     }
// }

// RANK 4: Brute Force Deleting Each Character — O(n²) Time, O(n) Space — SIMPLE / LEAST EFFICIENT
// class Solution {
//     public boolean validPalindrome(String s) {
//         if (isPalindrome(s)) return true;

//         for (int i = 0; i < s.length(); i++) {
//             String t = s.substring(0, i) + s.substring(i + 1);
//             if (isPalindrome(t)) return true;
//         }
//         return false;
//     }

//     private boolean isPalindrome(String s) {
//         int l = 0, r = s.length() - 1;
//         while (l < r) {
//             if (s.charAt(l++) != s.charAt(r--)) return false;
//         }
//         return true;
//     }
// }


// Driver code to test the Solution class
public class ValidPalindromeII {
    public static void main(String[] args) {

        Solution obj = new Solution();

        // Test 1
        String s1 = "aba";
        System.out.println("Input: " + s1);
        System.out.println("Valid Palindrome: " + obj.validPalindrome(s1));
        // true


        // Test 2
        String s2 = "abca";
        System.out.println("Input: " + s2);
        System.out.println("Valid Palindrome: " + obj.validPalindrome(s2));
        // true
        // Remove 'b' → "aca"


        // Test 3
        String s3 = "abc";
        System.out.println("Input: " + s3);
        System.out.println("Valid Palindrome: " + obj.validPalindrome(s3));
        // false


        // Test 4
        String s4 = "deeee";
        System.out.println("Input: " + s4);
        System.out.println("Valid Palindrome: " + obj.validPalindrome(s4));
        // true
    }
}