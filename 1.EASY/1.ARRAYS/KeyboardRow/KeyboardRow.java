// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: HashSet / Character Set Mapping — O(n × m) TIME, O(1) SPACE — BEST / MOST PRACTICAL
// class Solution {
//     public String[] findWords(String[] words) {

//         String[] rows = {
//                 "qwertyuiop",
//                 "asdfghjkl",
//                 "zxcvbnm"
//         };

//         List<String> result = new ArrayList<>();

//         for (String word : words) {

//             String lower = word.toLowerCase();

//             int row = -1;

//             // Find which keyboard row contains the first character
//             for (int i = 0; i < rows.length; i++) {

//                 if (rows[i].indexOf(lower.charAt(0)) != -1) {
//                     row = i;
//                     break;
//                 }
//             }

//             boolean valid = true;

//             // Check whether every character belongs to the same row
//             for (char ch : lower.toCharArray()) {

//                 if (rows[row].indexOf(ch) == -1) {
//                     valid = false;
//                     break;
//                 }
//             }

//             if (valid) {
//                 result.add(word);
//             }
//         }

//         return result.toArray(new String[0]);
//     }
// }

// RANK 2: HashMap Character → Row — O(n × m) TIME, O(1) SPACE — Direct / Efficient
// import java.util.*;
//
// class Solution {
//     public String[] findWords(String[] words) {
//
//         HashMap<Character, Integer> map = new HashMap<>();
//
//         String[] rows = {
//                 "qwertyuiop",
//                 "asdfghjkl",
//                 "zxcvbnm"
//         };
//
//         for (int row = 0; row < rows.length; row++) {
//
//             for (char ch : rows[row].toCharArray()) {
//                 map.put(ch, row);
//             }
//         }
//
//         List<String> result = new ArrayList<>();
//
//         for (String word : words) {
//
//             String lower = word.toLowerCase();
//
//             int row = map.get(lower.charAt(0));
//
//             boolean valid = true;
//
//             for (char ch : lower.toCharArray()) {
//
//                 if (map.get(ch) != row) {
//                     valid = false;
//                     break;
//                 }
//             }
//
//             if (valid) {
//                 result.add(word);
//             }
//         }
//
//         return result.toArray(new String[0]);
//     }
// }

// RANK 3: Character Array Row Mapping — O(n × m) TIME, O(1) SPACE — Direct / Practical
class Solution {

    char[] row1 = "qwertyuiopQWERTYUIOP".toCharArray();
    char[] row2 = "asdfghjklASDFGHJKL".toCharArray();
    char[] row3 = "zxcvbnmZXCVBNM".toCharArray();

    public String[] findWords(String[] words) {

        String[] result = new String[words.length];
        int l = 0;

        for (int i = 0; i < words.length; i++) {

            String s = words[i];
            char[] word = s.toCharArray();

            char[] currentRow = getRow(word[0]);
            boolean valid = true;

            for (int j = 1; j < word.length; j++) {

                if (getRow(word[j]) != currentRow) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result[l++] = s;
            }
        }

        String[] answer = new String[l];

        for (int i = 0; i < l; i++) {
            answer[i] = result[i];
        }

        return answer;
    }

    private char[] getRow(char character) {

        for (int i = 0; i < row1.length; i++) {
            if (character == row1[i]) {
                return row1;
            }
        }

        for (int i = 0; i < row2.length; i++) {
            if (character == row2[i]) {
                return row2;
            }
        }

        for (int i = 0; i < row3.length; i++) {
            if (character == row3[i]) {
                return row3;
            }
        }

        return new char[0];
    }
}

// RANK 4: Regular Expression — O(n × m) TIME, O(1) SPACE — Compact / Alternative
// import java.util.*;
//
// class Solution {
//     public String[] findWords(String[] words) {
//
//         List<String> result = new ArrayList<>();
//
//         for (String word : words) {
//
//             String lower = word.toLowerCase();
//
//             if (lower.matches("[qwertyuiop]+") ||
//                 lower.matches("[asdfghjkl]+") ||
//                 lower.matches("[zxcvbnm]+")) {
//
//                 result.add(word);
//             }
//         }
//
//         return result.toArray(new String[0]);
//     }
// }

// Driver code to test the Solution class
public class KeyboardRow {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        String[] words1 = {
                "Hello",
                "Alaska",
                "Dad",
                "Peace"
        };

        System.out.println(Arrays.toString(solution.findWords(words1)));
        // Answer: [Alaska, Dad]

        // Test Case 2
        String[] words2 = {
                "type",
                "row",
                "pop",
                "dad"
        };

        System.out.println(Arrays.toString(solution.findWords(words2)));
        // Answer: [type, row, pop, dad]

        // Test Case 3
        String[] words3 = {
                "qwerty",
                "asdf",
                "zxcv",
                "hello"
        };

        System.out.println(Arrays.toString(solution.findWords(words3)));
        // Answer: [qwerty, asdf, zxcv]

        // Test Case 4
        String[] words4 = {
                "Dad",
                "mom",
                "Peace"
        };

        System.out.println(Arrays.toString(solution.findWords(words4)));
        // Answer: [Dad]

        // Test Case 5
        String[] words5 = {
                "A",
                "b",
                "Z",
                "hello"
        };

        System.out.println(Arrays.toString(solution.findWords(words5)));
        // Answer: [A, b, Z]
    }
}