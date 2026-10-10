// ============================ FINAL DESTINATION ============================

// RANK 1: Monotonic Stack + HashMap — O(n + m) TIME, O(n) SPACE — BEST / OPTIMAL / MOST EFFICIENT

import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Find next greater element for every element in nums2
        for (int num : nums2) {

            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        // Elements remaining in stack have no greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build answer for nums1
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}


// RANK 2: Brute Force — O(n × m) TIME, O(1) EXTRA SPACE — SIMPLE / EASY TO UNDERSTAND
/*
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            int position = -1;

            // Find nums1[i] inside nums2
            for (int j = 0; j < nums2.length; j++) {

                if (nums2[j] == nums1[i]) {
                    position = j;
                    break;
                }
            }

            result[i] = -1;

            // Search for the first greater element
            for (int j = position + 1; j < nums2.length; j++) {

                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }
}
*/


// RANK 3: HashMap + Brute Force Search — O(n × m) TIME, O(n) SPACE — SIMPLE / HASHMAP ALTERNATIVE
/*
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> position = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            position.put(nums2[i], i);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            int start = position.get(nums1[i]);

            result[i] = -1;

            for (int j = start + 1; j < nums2.length; j++) {

                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }
}
*/


// Driver code to test the Solution class
public class NextGreaterElementI {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] nums1Tests = {
            {4, 1, 2},
            {2, 4},
            {1, 3, 5, 2, 4},
            {1},
            {5, 4, 3, 2, 1},
            {2, 1, 3},
            {3, 1, 5},
            {6, 7, 5}
        };

        int[][] nums2Tests = {
            {1, 3, 4, 2},
            {1, 2, 3, 4},
            {1, 3, 5, 2, 4},
            {1, 2, 3},
            {5, 4, 3, 2, 1},
            {2, 1, 3},
            {3, 1, 5, 7},
            {6, 7, 5, 8}
        };

        for (int i = 0; i < nums1Tests.length; i++) {

            int[] answer = solution.nextGreaterElement(
                nums1Tests[i],
                nums2Tests[i]
            );

            System.out.println(
                "Test " + (i + 1) + ": " +
                Arrays.toString(answer)
            );
        }

        /*
        Expected answers:

        Test 1: [-1, 3, -1]
        Test 2: [3, -1]
        Test 3: [3, 5, -1, 4, -1]
        Test 4: [2]
        Test 5: [-1, -1, -1, -1, -1]
        Test 6: [3, 3, -1]
        Test 7: [7, 5, 7]
        Test 8: [7, 8, 8]
        */
    }
}