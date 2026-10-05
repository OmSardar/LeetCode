// ============================ FINAL DESTINATION ============================

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// RANK 1: Recursive Divide & Conquer — O(n) TIME, O(log n) STACK SPACE — BEST / OPTIMAL / MOST NATURAL
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);

        return root;
    }
}

// RANK 2: Iterative DFS with Stack — O(n) TIME, O(n) SPACE — ITERATIVE ALTERNATIVE / NO RECURSION
// class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {

//         if (nums.length == 0) {
//             return null;
//         }

//         TreeNode root = new TreeNode(0);

//         Stack<Object[]> stack = new Stack<>();

//         stack.push(new Object[]{root, 0, nums.length - 1});

//         while (!stack.isEmpty()) {

//             Object[] current = stack.pop();

//             TreeNode node = (TreeNode) current[0];
//             int left = (int) current[1];
//             int right = (int) current[2];

//             int mid = left + (right - left) / 2;

//             node.val = nums[mid];

//             if (left <= mid - 1) {
//                 node.left = new TreeNode(0);
//                 stack.push(new Object[]{node.left, left, mid - 1});
//             }

//             if (mid + 1 <= right) {
//                 node.right = new TreeNode(0);
//                 stack.push(new Object[]{node.right, mid + 1, right});
//             }
//         }

//         return root;
//     }
// }

// RANK 3: Iterative BFS with Queue — O(n) TIME, O(n) SPACE — SIMPLE / LEVEL-BY-LEVEL ALTERNATIVE
// class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {

//         if (nums.length == 0) {
//             return null;
//         }

//         TreeNode root = null;

//         Queue<Object[]> queue = new LinkedList<>();

//         queue.offer(new Object[]{0, nums.length - 1, null, 0});

//         while (!queue.isEmpty()) {

//             Object[] current = queue.poll();

//             int left = (int) current[0];
//             int right = (int) current[1];
//             TreeNode parent = (TreeNode) current[2];
//             int side = (int) current[3];

//             if (left > right) {
//                 continue;
//             }

//             int mid = left + (right - left) / 2;

//             TreeNode node = new TreeNode(nums[mid]);

//             if (parent == null) {
//                 root = node;
//             } else if (side == 0) {
//                 parent.left = node;
//             } else {
//                 parent.right = node;
//             }

//             queue.offer(new Object[]{left, mid - 1, node, 0});
//             queue.offer(new Object[]{mid + 1, right, node, 1});
//         }

//         return root;
//     }
// }

// RANK 4: Brute Force Insertion — O(n²) TIME, O(n) SPACE — SIMPLE CONCEPT / LEAST EFFICIENT
// class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {

//         TreeNode root = null;

//         for (int num : nums) {
//             root = insert(root, num);
//         }

//         return root;
//     }

//     private TreeNode insert(TreeNode root, int value) {

//         if (root == null) {
//             return new TreeNode(value);
//         }

//         if (value < root.val) {
//             root.left = insert(root.left, value);
//         } else {
//             root.right = insert(root.right, value);
//         }

//         return root;
//     }
// }

// Driver code to test the Solution class
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Odd number of elements
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = solution.sortedArrayToBST(nums1);
        System.out.println("Test Case 1: " + levelOrder(root1)); // Answer: [0, -3, 9, -10, 5]

        // Test Case 2: Single element
        int[] nums2 = {1};
        TreeNode root2 = solution.sortedArrayToBST(nums2);
        System.out.println("Test Case 2: " + levelOrder(root2)); // Answer: [1]

        // Test Case 3: Two elements
        int[] nums3 = {1, 3};
        TreeNode root3 = solution.sortedArrayToBST(nums3);
        System.out.println("Test Case 3: " + levelOrder(root3)); // Answer: [1, 3]

        // Test Case 4: Three elements
        int[] nums4 = {1, 2, 3};
        TreeNode root4 = solution.sortedArrayToBST(nums4);
        System.out.println("Test Case 4: " + levelOrder(root4)); // Answer: [2, 1, 3]

        // Test Case 5: Seven elements
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root5 = solution.sortedArrayToBST(nums5);
        System.out.println("Test Case 5: " + levelOrder(root5)); // Answer: [4, 2, 6, 1, 3, 5, 7]

        // Test Case 6: Negative and positive values
        int[] nums6 = {-5, -2, 0, 3, 8};
        TreeNode root6 = solution.sortedArrayToBST(nums6);
        System.out.println("Test Case 6: " + levelOrder(root6)); // Answer: [0, -5, 3, -2, 8]

        // Test Case 7: Empty array
        int[] nums7 = {};
        TreeNode root7 = solution.sortedArrayToBST(nums7);
        System.out.println("Test Case 7: " + levelOrder(root7)); // Answer: []

        // Test Case 8: Larger array
        int[] nums8 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root8 = solution.sortedArrayToBST(nums8);
        System.out.println("Test Case 8: " + levelOrder(root8)); // Answer: [5, 2, 7, 1, 3, 6, 8, 4, 9]
    }

    // Helper method to print tree in level-order
    private static String levelOrder(TreeNode root) {

        if (root == null) {
            return "[]";
        }

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        java.util.List<Integer> result = new java.util.ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            result.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return result.toString();
    }
}