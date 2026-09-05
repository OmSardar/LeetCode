// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Two Pointers + StringBuilder — O(n + m) TIME, O(n + m) SPACE — BEST / OPTIMAL / MOST DIRECT
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i++));
            }
            if (j < word2.length()) {
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }
}

// RANK 2: StringBuilder + Index Loop — O(n + m) TIME, O(n + m) SPACE — SIMPLE / CLEAN / EASY TO UNDERSTAND
// class Solution {
//     public String mergeAlternately(String word1, String word2) {
//         StringBuilder result = new StringBuilder();
//         int i = 0;

//         while (i < word1.length() || i < word2.length()) {
//             if (i < word1.length()) {
//                 result.append(word1.charAt(i));
//             }
//             if (i < word2.length()) {
//                 result.append(word2.charAt(i));
//             }
//             i++;
//         }

//         return result.toString();
//     }
// }

// RANK 3: for Loop + Math.max() — O(n + m) TIME, O(n + m) SPACE — SIMPLE / CONCISE / GOOD ALTERNATIVE
// class Solution {
//     public String mergeAlternately(String word1, String word2) {
//         StringBuilder sb = new StringBuilder();
//         int max = Math.max(word1.length(), word2.length());

//         for (int i = 0; i < max; i++) {
//             if (i < word1.length()) {
//                 sb.append(word1.charAt(i));
//             }
//             if (i < word2.length()) {
//                 sb.append(word2.charAt(i));
//             }
//         }

//         return sb.toString();
//     }
// }

// RANK 4: Character Arrays + StringBuilder — O(n + m) TIME, O(n + m) SPACE — WORKS BUT EXTRA ARRAY OVERHEAD
// class Solution {
//     public String mergeAlternately(String word1, String word2) {
//         char[] a = word1.toCharArray();
//         char[] b = word2.toCharArray();
//         StringBuilder sb = new StringBuilder();

//         int i = 0;
//         while (i < a.length || i < b.length) {
//             if (i < a.length) sb.append(a[i]);
//             if (i < b.length) sb.append(b[i]);
//             i++;
//         }

//         return sb.toString();
//     }
// }

// Driver code to test the Solution class
public class MergeStringsAlternately {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Same length
        String word1 = "abc";
        String word2 = "pqr";

        System.out.println(solution.mergeAlternately(word1, word2)); // Answer: "apbqcr"

        // Test Case 2: word1 is longer
        String word3 = "abcd";
        String word4 = "pq";

        System.out.println(solution.mergeAlternately(word3, word4)); // Answer: "apbqcd"

        // Test Case 3: word2 is longer
        String word5 = "ab";
        String word6 = "pqrs";

        System.out.println(solution.mergeAlternately(word5, word6)); // Answer: "apbqrs"

        // Test Case 4: Single character strings
        String word7 = "a";
        String word8 = "b";

        System.out.println(solution.mergeAlternately(word7, word8)); // Answer: "ab"

        // Test Case 5: One empty string
        String word9 = "";
        String word10 = "abc";

        System.out.println(solution.mergeAlternately(word9, word10)); // Answer: "abc"

        // Test Case 6: Both empty
        String word11 = "";
        String word12 = "";

        System.out.println(solution.mergeAlternately(word11, word12)); // Answer: ""

        // Test Case 7: Different length words
        String word13 = "hello";
        String word14 = "world";

        System.out.println(solution.mergeAlternately(word13, word14)); // Answer: "hweolrllod"

        // Test Case 8: Longer strings
        String word15 = "abcdef";
        String word16 = "123";

        System.out.println(solution.mergeAlternately(word15, word16)); // Answer: "a1b2c3def"
    }
}