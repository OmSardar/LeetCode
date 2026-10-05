// ============================ FINAL DESTINATION ============================

// RANK 1: Two Pointers + Character Array — O(n) TIME, O(n) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        return new String(chars);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}

// RANK 2: Collect Vowels + Replace — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO VISUALIZE

// class Solution {
//     public String reverseVowels(String s) {
//
//         char[] chars = s.toCharArray();
//
//         int left = 0;
//         int right = chars.length - 1;
//
//         while (left < right) {
//
//             if (!isVowel(chars[left])) {
//                 left++;
//                 continue;
//             }
//
//             if (!isVowel(chars[right])) {
//                 right--;
//                 continue;
//             }
//
//             char temp = chars[left];
//             chars[left] = chars[right];
//             chars[right] = temp;
//
//             left++;
//             right--;
//         }
//
//         return new String(chars);
//     }
//
//     private boolean isVowel(char ch) {
//         return "aeiouAEIOU".indexOf(ch) != -1;
//     }
// }


// RANK 3: Two Pointers + StringBuilder — O(n) TIME, O(n) SPACE — CLEAR / EASY TO UNDERSTAND

// class Solution {
//     public String reverseVowels(String s) {
//
//         char[] chars = s.toCharArray();
//
//         StringBuilder vowels = new StringBuilder();
//
//         for (char ch : chars) {
//             if (isVowel(ch)) {
//                 vowels.append(ch);
//             }
//         }
//
//         vowels.reverse();
//
//         int index = 0;
//
//         for (int i = 0; i < chars.length; i++) {
//             if (isVowel(chars[i])) {
//                 chars[i] = vowels.charAt(index++);
//             }
//         }
//
//         return new String(chars);
//     }
//
//     private boolean isVowel(char ch) {
//         return "aeiouAEIOU".indexOf(ch) != -1;
//     }
// }


// Driver code to test the Solution class
public class ReverseVowelsOfAString {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
            solution.reverseVowels("hello")
        ); // Answer: holle

        // Test Case 2
        System.out.println(
            solution.reverseVowels("leetcode")
        ); // Answer: leotcede

        // Test Case 3
        System.out.println(
            solution.reverseVowels("aA")
        ); // Answer: Aa

        // Test Case 4
        System.out.println(
            solution.reverseVowels("hello world")
        ); // Answer: hollo werld

        // Test Case 5
        System.out.println(
            solution.reverseVowels("bcdfg")
        ); // Answer: bcdfg
    }
}