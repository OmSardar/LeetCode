// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Greedy with Counters — O(n) time, O(1) space — BEST SOLUTION / SIMPLEST / FASTEST / OPTIMAL
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fives += 1;
            } else if (bill == 10) {
                if (fives > 0) {
                    tens += 1;
                    fives -= 1;
                } else {
                    return false;
                }
            } else {
                if (bill == 20) {
                    if (fives > 0 && tens > 0) {
                        tens -= 1;
                        fives -= 1;
                    } else {
                        if (fives >= 3) {
                            fives -= 3;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

// RANK 2: Greedy with Early Exit Checks — O(n) time, O(1) space — SAME OPTIMAL COMPLEXITY / EXPLICIT VALIDATION / CLEAN GREEDY APPROACH
// class Solution {
//     public boolean lemonadeChange(int[] bills) {
//         int five = 0;
//         int ten = 0;

//         for (int i = 0; i < bills.length; i++) {
//             if (bills[i] == 5) {
//                 five++;
//             } 
//             else if (bills[i] == 10) {
//                 if (five < 1) return false;
//                 five--;
//                 ten++;
//             } 
//             else {
//                 if (ten >= 1 && five >= 1) {
//                     ten--;
//                     five--;
//                 } else if (five >= 3) {
//                     five -= 3;
//                 } else {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }

// RANK 3: Simulation Using HashMap — O(n) average time, O(1) space — GOOD FOR LEARNING SIMULATION / FLEXIBLE DATA STRUCTURE / MORE VERBOSE
// import java.util.*;

// class Solution {
//     public boolean lemonadeChange(int[] bills) {
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(5, 0);
//         map.put(10, 0);

//         for (int bill : bills) {
//             if (bill == 5) {
//                 map.put(5, map.get(5) + 1);
//             } 
//             else if (bill == 10) {
//                 if (map.get(5) == 0) return false;
//                 map.put(5, map.get(5) - 1);
//                 map.put(10, map.get(10) + 1);
//             } 
//             else { // 20
//                 if (map.get(10) > 0 && map.get(5) > 0) {
//                     map.put(10, map.get(10) - 1);
//                     map.put(5, map.get(5) - 1);
//                 } else if (map.get(5) >= 3) {
//                     map.put(5, map.get(5) - 3);
//                 } else {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }

// Driver code to test the Solution class
public class LemonadeChange {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] tests = {
                { 5, 5, 5, 10, 20 }, // true
                { 5, 5, 10, 10, 20 }, // false
                { 10 }, // false
                { 5, 5, 5, 5, 10, 10, 20 }, // true
                { 5, 5, 10, 5, 20, 10 } // true
        };

        for (int[] bills : tests) {
            System.out.println(solution.lemonadeChange(bills));
        }
    }
}
