// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Integer Mapping Array + Adjacent Comparison — O(C + W), O(1) EXTRA SPACE — BEST / MOST EFFICIENT / OPTIMAL
class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];

            int j = 0;
            while (j < a.length() && j < b.length()) {
                if (a.charAt(j) != b.charAt(j)) {
                    if (map[a.charAt(j) - 'a'] > map[b.charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
                j++;
            }

            if (j == b.length() && a.length() > b.length()) {
                return false;
            }
        }
        return true;
    }
}


// RANK 2: Alien-Numeric Comparison — O(C + W), O(1) EXTRA SPACE — CLEAN / STRUCTURED / GOOD ALTERNATIVE
// class Solution {
//     public boolean isAlienSorted(String[] words, String order) {

//         int[] map = new int[26];
//         for (int i = 0; i < 26; i++) {
//             map[order.charAt(i) - 'a'] = i;
//         }

//         for (int i = 0; i < words.length - 1; i++) {
//             if (compare(words[i], words[i + 1], map) > 0) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private int compare(String a, String b, int[] map) {
//         int len = Math.min(a.length(), b.length());
//         for (int i = 0; i < len; i++) {
//             int diff = map[a.charAt(i) - 'a'] - map[b.charAt(i) - 'a'];
//             if (diff != 0) return diff;
//         }
//         return a.length() - b.length();
//     }
// }


// RANK 3: HashMap + Manual Comparison — O(C + W), O(1) EXTRA SPACE — READABLE / GOOD ALTERNATIVE
// class Solution {
//     public boolean isAlienSorted(String[] words, String order) {

//         // Step 1: Create rank map
//         int[] rank = new int[26];
//         for (int i = 0; i < order.length(); i++) {
//             rank[order.charAt(i) - 'a'] = i;
//         }

//         // Step 2: Compare adjacent words
//         for (int i = 0; i < words.length - 1; i++) {
//             if (!inCorrectOrder(words[i], words[i + 1], rank)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private boolean inCorrectOrder(String w1, String w2, int[] rank) {
//         int len = Math.min(w1.length(), w2.length());

//         for (int i = 0; i < len; i++) {
//             char c1 = w1.charAt(i);
//             char c2 = w2.charAt(i);

//             if (rank[c1 - 'a'] < rank[c2 - 'a']) return true;
//             if (rank[c1 - 'a'] > rank[c2 - 'a']) return false;
//         }

//         // If all chars same, shorter word should come first
//         return w1.length() <= w2.length();
//     }
// }

// Driver code to test the Solution class
public class VerifyingAnAlienDictionary {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Basic Valid Order
        String[] words1 = {"hello", "leetcode"};
        String order1 = "hlabcdefgijkmnopqrstuvwxyz";

        System.out.println(solution.isAlienSorted(words1, order1)); // Answer: true


        // Test Case 2: Invalid Order
        String[] words2 = {"word", "world", "row"};
        String order2 = "worldabcefghijkmnpqstuvxyz";

        System.out.println(solution.isAlienSorted(words2, order2)); // Answer: false


        // Test Case 3: Valid Prefix Case
        String[] words3 = {"apple", "app"};
        String order3 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(solution.isAlienSorted(words3, order3)); // Answer: false


        // Test Case 4: Same Words
        String[] words4 = {"abc", "abc"};
        String order4 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(solution.isAlienSorted(words4, order4)); // Answer: true


        // Test Case 5: Single Word
        String[] words5 = {"hello"};
        String order5 = "hlabcdefgijkmnopqrstuvwxyz";

        System.out.println(solution.isAlienSorted(words5, order5)); // Answer: true


        // Test Case 6: Reverse Order
        String[] words6 = {"zoo", "apple"};
        String order6 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(solution.isAlienSorted(words6, order6)); // Answer: false


        // Test Case 7: Multiple Valid Words
        String[] words7 = {"app", "apple", "banana", "cat"};
        String order7 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(solution.isAlienSorted(words7, order7)); // Answer: true
    }
}
