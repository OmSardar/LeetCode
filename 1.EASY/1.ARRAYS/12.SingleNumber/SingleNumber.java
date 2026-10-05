// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: XOR Method — O(n), O(1) — BEST / MOST EFFICIENT
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}

// RANK 2: HashSet Method — O(n), O(n)
// import java.util.*;

// class Solution {
//     public int singleNumber(int[] nums) {
//         Set<Integer> set = new HashSet<>();

//         for (int num : nums) {
//             if (!set.add(num)) {
//                 set.remove(num);
//             }
//         }
//         return set.iterator().next();
//     }
// }

// RANK 3: Math Formula Trick — O(n), O(n)
// import java.util.*;

// class Solution {
//     public int singleNumber(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         int arraySum = 0;
//         int setSum = 0;
//         for (int num : nums) {
//             if (set.add(num)) {
//                 setSum += num;
//             }
//             arraySum += num;
//         }
//         int result = 2*setSum - arraySum;
//         return result;
//     }
// }

// RANK 4: HashMap Counting Method — O(n), O(n)
// import java.util.HashMap;
// class Solution {
//     public int singleNumber(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
//         for (int key : map.keySet()) {
//             if (map.get(key) == 1) {
//                 return key;
//             }
//         }
//         return -1;
//     }
// }

// RANK 5: Sorting Method — O(n log n), O(1) — WORST / LEAST EFFICIENT
// import java.util.Arrays;

// class Solution {
//     public int singleNumber(int[] nums) {
//         Arrays.sort(nums);

//         for (int i = 0; i < nums.length - 1; i += 2) {
//             if (nums[i] != nums[i + 1]) {
//                 return nums[i];
//             }
//         }

//         return nums[nums.length - 1];
//     }
// }

// Driver code to test the Solution class
public class SingleNumber {
    public static void main(String[] args) {

        int[] nums = {4, 3, 4, 1, 2, 1, 2};

        Solution obj = new Solution();

        System.out.println(obj.singleNumber(nums));
    }
}