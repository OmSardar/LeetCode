// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: HashMap — O(n + m) TIME, O(n + k) SPACE — Best / Most Practical

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            String restaurant = list2[j];

            if (map.containsKey(restaurant)) {
                int sum = map.get(restaurant) + j;

                if (sum < minSum) {
                    minSum = sum;
                    result.clear();
                    result.add(restaurant);
                } else if (sum == minSum) {
                    result.add(restaurant);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}

// RANK 2: Brute Force — O(n × m) TIME, O(k) SPACE — Basic / Educational
// class Solution {
//     public String[] findRestaurant(String[] list1, String[] list2) {

//         List<String> result = new ArrayList<>();

//         int minSum = Integer.MAX_VALUE;

//         for (int i = 0; i < list1.length; i++) {
//             for (int j = 0; j < list2.length; j++) {
//                 if (list1[i].equals(list2[j])) {

//                     int sum = i + j;

//                     if (sum < minSum) {
//                         minSum = sum;
//                         result.clear();
//                         result.add(list1[i]);
//                     } else if (sum == minSum) {
//                         result.add(list1[i]);
//                     }
//                 }
//             }
//         }
//         return result.toArray(new String[0]);
//     }
// }

// RANK 3: Sorting + Two Pointers — O(n log n + m log m) TIME, O(n + m) SPACE — Alternative

// class Solution {
//     public String[] findRestaurant(String[] list1, String[] list2) {
//         // Store each restaurant with its original index
//         String[][] arr1 = new String[list1.length][2];
//         String[][] arr2 = new String[list2.length][2];

//         for (int i = 0; i < list1.length; i++) {
//             arr1[i][0] = list1[i];
//             arr1[i][1] = String.valueOf(i);
//         }

//         for (int i = 0; i < list2.length; i++) {
//             arr2[i][0] = list2[i];
//             arr2[i][1] = String.valueOf(i);
//         }

//         // Sort both arrays alphabetically by restaurant name
//         Arrays.sort(arr1, (a, b) -> a[0].compareTo(b[0]));
//         Arrays.sort(arr2, (a, b) -> a[0].compareTo(b[0]));

//         List<String> result = new ArrayList<>();
//         int minSum = Integer.MAX_VALUE;
//         int i = 0, j = 0;

//         while (i < arr1.length && j < arr2.length) {
//             int comparison = arr1[i][0].compareTo(arr2[j][0]);

//             if (comparison == 0) {
//                 int index1 = Integer.parseInt(arr1[i][1]);
//                 int index2 = Integer.parseInt(arr2[j][1]);
//                 int sum = index1 + index2;

//                 if (sum < minSum) {
//                     minSum = sum;
//                     result.clear();
//                     result.add(arr1[i][0]);
//                 } else if (sum == minSum) {
//                     result.add(arr1[i][0]);
//                 }

//                 i++;
//                 j++;
//             } else if (comparison < 0) {
//                 i++;
//             } else {
//                 j++;
//             }
//         }

//         return result.toArray(new String[0]);
//     }
// }

// Driver code to test the Solution class
public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill", "Shogun", "KFC"};
        System.out.println(Arrays.toString(solution.findRestaurant(list1, list2)));
        // Answer: [Shogun]

        // Test Case 2
        String[] list3 = {"Shogun", "KFC", "Burger King"};
        String[] list4 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(solution.findRestaurant(list3, list4)));
        // Answer: [Shogun, KFC]

        // Test Case 3
        String[] list5 = {"A", "B", "C"};
        String[] list6 = {"C", "B", "A"};
        System.out.println(Arrays.toString(solution.findRestaurant(list5, list6)));
        // Answer: [A, B, C]

        // Test Case 4
        String[] list7 = {"A", "B", "C"};
        String[] list8 = {"D", "E", "B"};
        System.out.println(Arrays.toString(solution.findRestaurant(list7, list8)));
        // Answer: [B]

        // Test Case 5
        String[] list9 = {"A", "B"};
        String[] list10 = {"C", "D"};
        System.out.println(Arrays.toString(solution.findRestaurant(list9, list10)));
        // Answer: []
    }
}