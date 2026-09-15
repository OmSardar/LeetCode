// ============================ JULY-AUGUST PRACTICE ============================

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

// RANK 1: Min Heap (PriorityQueue) — O(log k) per add, O(k) space — BEST PRACTICAL / MOST EFFICIENT / MOST USED
import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}


// RANK 2: TreeMap (Balanced BST) — O(n log n) per add, O(n) space — ORDERED / DUPLICATE-AWARE APPROACH
// import java.util.*;

// class KthLargest {
//     private TreeMap<Integer, Integer> map;
//     private int k;

//     public KthLargest(int k, int[] nums) {
//         this.k = k;
//         map = new TreeMap<>();
//         for (int num : nums) {
//             add(num);
//         }
//     }

//     public int add(int val) {
//         map.put(val, map.getOrDefault(val, 0) + 1);

//         int count = 0;
//         for (int key : map.descendingKeySet()) {
//             count += map.get(key);
//             if (count >= k) {
//                 return key;
//             }
//         }
//         return -1;
//     }
// }

// RANK 3: Sorting Every Time — O(n log n) per add, O(n) space — SIMPLE / EASY TO UNDERSTAND / LEAST EFFICIENT
// import java.util.*;
// class KthLargest {
//     private List<Integer> list;
//     private int k;

//     public KthLargest(int k, int[] nums) {
//         this.k = k;
//         list = new ArrayList<>();
//         for (int num : nums) {
//             list.add(num);
//         }
//     }

//     public int add(int val) {
//         list.add(val);
//         Collections.sort(list, Collections.reverseOrder());
//         return list.get(k - 1);
//     }
// }

// Driver code to test the KthLargest class
public class KthLargestElementInAStream {
    public static void main(String[] args) {

        // Test Case 1
        int k1 = 3;
        int[] nums1 = {4, 5, 8, 2};
        KthLargest obj1 = new KthLargest(k1, nums1);

        System.out.println("Test Case 1:");
        System.out.println("add(3)  -> " + obj1.add(3));   // 4
        System.out.println("add(5)  -> " + obj1.add(5));   // 5
        System.out.println("add(10) -> " + obj1.add(10));  // 5
        System.out.println("add(9)  -> " + obj1.add(9));   // 8
        System.out.println("add(4)  -> " + obj1.add(4));   // 8
        System.out.println("------------------------");


        // Test Case 2
        int k2 = 2;
        int[] nums2 = {0};
        KthLargest obj2 = new KthLargest(k2, nums2);

        System.out.println("Test Case 2:");
        System.out.println("add(-1) -> " + obj2.add(-1));  // -1
        System.out.println("add(1)  -> " + obj2.add(1));   // 0
        System.out.println("add(-2) -> " + obj2.add(-2));  // 0
        System.out.println("add(-4) -> " + obj2.add(-4));  // 0
        System.out.println("add(3)  -> " + obj2.add(3));   // 1
        System.out.println("------------------------");


        // Test Case 3
        int k3 = 1;
        int[] nums3 = {5, 2, 9, 1};
        KthLargest obj3 = new KthLargest(k3, nums3);

        System.out.println("Test Case 3:");
        System.out.println("add(6)  -> " + obj3.add(6));    // 9
        System.out.println("add(10) -> " + obj3.add(10));   // 10
        System.out.println("add(3)  -> " + obj3.add(3));    // 10
        System.out.println("------------------------");


        // Test Case 4
        int k4 = 4;
        int[] nums4 = {2, 2, 3, 1};
        KthLargest obj4 = new KthLargest(k4, nums4);

        System.out.println("Test Case 4:");
        System.out.println("add(4) -> " + obj4.add(4));     // 2
        System.out.println("add(5) -> " + obj4.add(5));     // 2
        System.out.println("add(6) -> " + obj4.add(6));     // 3
        System.out.println("------------------------");


        // Test Case 5
        int k5 = 3;
        int[] nums5 = {1, 2, 3};
        KthLargest obj5 = new KthLargest(k5, nums5);

        System.out.println("Test Case 5:");
        System.out.println("add(5)  -> " + obj5.add(5));   // 3
        System.out.println("add(2)  -> " + obj5.add(2));   // 3
        System.out.println("add(10) -> " + obj5.add(10));  // 5
        System.out.println("add(8)  -> " + obj5.add(8));   // 8
        System.out.println("------------------------");

    }
}
