// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Two Pointers from Back (BEST / OPTIMAL) — O(m+n), O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = (m+n) - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        while (i >= 0) {
            nums1[k] = nums1[i];
            k--;
            i--;
        }
        while (j >= 0) {
                nums1[k] = nums2[j];
                k--;
                j--;
        }
    }
}

// RANK 2: Two Pointers from Front — O(m+n), O(m)
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int copy[] = new int[m];
//         for (int i = 0; i < m; i++) {
//             copy[i] = nums1[i];
//         }
//         int i = 0;
//         int j = 0;
//         int k = 0;
//         while (i < m && j < n) {
//             if (copy[i] < nums2[j]) {
//                 nums1[k] = copy[i];
//                 k++;
//                 i++;
//             } else {
//                 nums1[k] = nums2[j];
//                 k++;
//                 j++;
//             }
//         }
//         while (i < m) {
//             nums1[k] = copy[i];
//             k++;
//             i++;
//         }
//         while (j < n) {
//                 nums1[k] = nums2[j];
//                 k++;
//                 j++;
//         }
//     }
// }

// RANK 3: Extra Array — O(m+n), O(m+n)
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int[] temp = new int[m + n];

//         int i = 0;
//         int j = 0;
//         int k = 0;

//         while (i < m && j < n) {
//             if (nums1[i] <= nums2[j]) {
//                 temp[k++] = nums1[i++];
//             } else {
//                 temp[k++] = nums2[j++];
//             }
//         }

//         while (i < m) {
//             temp[k++] = nums1[i++];
//         }

//         while (j < n) {
//             temp[k++] = nums2[j++];
//         }

//         for (int x = 0; x < m + n; x++) {
//             nums1[x] = temp[x];
//         }
//     }
// }

// RANK 4: Copy nums2 + Sort — O((m+n)log(m+n)), O(1)
// import java.util.Arrays;

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         for (int i = 0; i < n; i++) {
//             nums1[m + i] = nums2[i];
//         }
//         Arrays.sort(nums1);
//     }
// }

// Driver code to test the Solution class
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };

        obj.merge(nums1, 3, nums2, 3);

        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}