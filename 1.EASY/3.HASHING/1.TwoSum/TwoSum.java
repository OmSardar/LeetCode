// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1 : O(n)
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}


// RANK 2 : (O(n log n))
// import java.util.Arrays;

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int arr[][] = new int[nums.length][2];

//         for(int i=0; i<nums.length; i++){
//             arr[i][0] = nums[i];
//             arr[i][1] = i;
//         }
//         Arrays.sort(arr, (a,b) -> a[0] - b[0]);

//         int left = 0;
//         int right = nums.length - 1;
//         while(left<right){
//             int leftValue = arr[left][0];
//             int rightValue = arr[right][0];
//             int sum = leftValue + rightValue;
//             if (sum == target){
//                 return new int[]{arr[left][1], arr[right][1]};
//             }
//             if (sum < target){
//                 left++;
//             }
//             else{
//                 right--;
//             }
//         }
//         return new int[]{};
//     }
// }

// RANK 3 : O(n*n)
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for(int i=0; i<nums.length; i++){
//             for(int j=i+1; j<nums.length; j++){
//                 if(nums[i] + nums[j]==target){
//                     return new int[]{i,j};
//                 }

//             }
                
//         }
//         return new int[]{};
//     }
// }

//Driver code to test the Solution class
class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}