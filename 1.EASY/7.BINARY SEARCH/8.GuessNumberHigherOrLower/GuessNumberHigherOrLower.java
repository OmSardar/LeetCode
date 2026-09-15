// ============================ JULY-AUGUST PRACTICE ============================

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
// Simulates LeetCode's GuessGame class for LOCAL testing.
class GuessGame {

    static int secretNumber = 6;

    public int guess(int num) {
        if (num > secretNumber) {
            return -1;
        } else if (num < secretNumber) {
            return 1;
        } else {
            return 0;
        }
    }
}

// RANK 1: Binary Search (Iterative) — O(log n) Time, O(1) Space — BEST PRACTICAL / MOST EFFICIENT / INTERVIEW FAVORITE
class Solution extends GuessGame {

    public int guessNumber(int n) {

        int low = 1;
        int high = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int res = guess(mid);

            if (res == 0) {
                return mid;
            } else if (res == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

// RANK 2: Binary Search (Recursive) — O(log n) Time, O(log n) Space — EFFICIENT / CLEAN / RECURSIVE
// class Solution extends GuessGame {

//     public int guessNumber(int n) {
//         return binarySearch(1, n);
//     }

//     private int binarySearch(int low, int high) {

//          if (low > high) {
//             return -1;
//         }

//         int mid = low + (high - low) / 2;

//             int res = guess(mid);

//             if (res == 0) {
//                 return mid;
//             } else if (res == -1) {
//                 return binarySearch(low, mid - 1);
//             } else {
//                 return binarySearch(mid + 1, high);
//             }
//     }
// }


// RANK 3: Brute Force (Linear Search) — O(n) Time, O(1) Space — SIMPLEST / EASY TO UNDERSTAND / LEAST EFFICIENT

// class Solution extends GuessGame {

//     public int guessNumber(int n) {

//         for (int i = 1; i <= n; i++) {

//             if (guess(i) == 0) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }


// Driver code to test the Solution class
public class GuessNumberHigherOrLower {
    public static void main(String[] args) {

        // Test 1
        GuessGame.secretNumber = 6;

        Solution obj = new Solution();

        int n1 = 10;

        System.out.println("Secret Number: " + GuessGame.secretNumber);
        System.out.println("Guessed Number: " + obj.guessNumber(n1));
        // Guessed Number: 6


        // Test 2
        GuessGame.secretNumber = 1;

        int n2 = 10;

        System.out.println("Secret Number: " + GuessGame.secretNumber);
        System.out.println("Guessed Number: " + obj.guessNumber(n2));
        // Guessed Number: 1


        // Test 3
        GuessGame.secretNumber = 10;

        int n3 = 10;

        System.out.println("Secret Number: " + GuessGame.secretNumber);
        System.out.println("Guessed Number: " + obj.guessNumber(n3));
        // Guessed Number: 10
    }
}