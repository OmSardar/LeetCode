// ============================ FINAL DESTINATION ============================

// RANK 1: Binary Search — O(log n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return letters[low % letters.length];
    }
}

// RANK 2: Linear Search — O(n) TIME, O(1) SPACE — Simple / Direct

// class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//
//         for (char letter : letters) {
//
//             if (letter > target) {
//                 return letter;
//             }
//         }
//
//         return letters[0];
//     }
// }


// RANK 3: Linear Search with Index — O(n) TIME, O(1) SPACE — Alternative / Simple

// class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//
//         int i = 0;
//
//         while (i < letters.length) {
//
//             if (letters[i] > target) {
//                 return letters[i];
//             }
//
//             i++;
//         }
//
//         return letters[0];
//     }
// }


// Driver code to test the Solution class
public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        char[] letters1 = {'c', 'f', 'j'};
        char target1 = 'a';

        System.out.println(solution.nextGreatestLetter(letters1, target1));
        // Answer: c


        // Test Case 2
        char[] letters2 = {'c', 'f', 'j'};
        char target2 = 'c';

        System.out.println(solution.nextGreatestLetter(letters2, target2));
        // Answer: f


        // Test Case 3
        char[] letters3 = {'c', 'f', 'j'};
        char target3 = 'd';

        System.out.println(solution.nextGreatestLetter(letters3, target3));
        // Answer: f


        // Test Case 4
        char[] letters4 = {'c', 'f', 'j'};
        char target4 = 'j';

        System.out.println(solution.nextGreatestLetter(letters4, target4));
        // Answer: c


        // Test Case 5
        char[] letters5 = {'c', 'f', 'j'};
        char target5 = 'z';

        System.out.println(solution.nextGreatestLetter(letters5, target5));
        // Answer: c


        // Test Case 6
        char[] letters6 = {'e', 'e', 'e', 'k', 'k'};
        char target6 = 'e';

        System.out.println(solution.nextGreatestLetter(letters6, target6));
        // Answer: k


        // Test Case 7
        char[] letters7 = {'a', 'b', 'c', 'd'};
        char target7 = 'b';

        System.out.println(solution.nextGreatestLetter(letters7, target7));
        // Answer: c
    }
}