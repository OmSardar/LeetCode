// ============================ FINAL DESTINATION ============================

import java.util.HashSet;

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

// RANK 1: DFS + HashSet — O(n) TIME, O(n) SPACE — BEST / MOST PRACTICAL
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> seen = new HashSet<>();
        return dfs(root, k, seen);
    }

    private boolean dfs(TreeNode root, int k, HashSet<Integer> seen) {
        if (root == null) {
            return false;
        }
        int needed = k - root.val;
        if (seen.contains(needed)) {
            return true;
        }
        seen.add(root.val);

        return dfs(root.left, k, seen) || dfs(root.right, k, seen);
    }
}

// RANK 2: Inorder + Two Pointers — O(n) TIME, O(n) SPACE — Uses BST Property
// import java.util.ArrayList;
//
// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//
//         ArrayList<Integer> values = new ArrayList<>();
//         inorder(root, values);
//
//         int left = 0;
//         int right = values.size() - 1;
//
//         while (left < right) {
//
//             int sum = values.get(left) + values.get(right);
//
//             if (sum == k) {
//                 return true;
//             }
//
//             if (sum < k) {
//                 left++;
//             } else {
//                 right--;
//             }
//         }
//
//         return false;
//     }
//
//     private void inorder(TreeNode root, ArrayList<Integer> values) {
//
//         if (root == null) {
//             return;
//         }
//
//         inorder(root.left, values);
//         values.add(root.val);
//         inorder(root.right, values);
//     }
// }

// RANK 3: Inorder + HashSet — O(n) TIME, O(n) SPACE — Alternative
// import java.util.ArrayList;
// import java.util.HashSet;
//
// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//
//         ArrayList<Integer> values = new ArrayList<>();
//         inorder(root, values);
//
//         HashSet<Integer> seen = new HashSet<>();
//
//         for (int value : values) {
//
//             int needed = k - value;
//
//             if (seen.contains(needed)) {
//                 return true;
//             }
//
//             seen.add(value);
//         }
//
//         return false;
//     }
//
//     private void inorder(TreeNode root, ArrayList<Integer> values) {
//
//         if (root == null) {
//             return;
//         }
//
//         inorder(root.left, values);
//         values.add(root.val);
//         inorder(root.right, values);
//     }
// }


// Driver code to test the Solution class
public class TwoSumIVInputIsABST {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        TreeNode root1 = new TreeNode(
                5,
                new TreeNode(
                        3,
                        new TreeNode(2),
                        new TreeNode(4)),
                new TreeNode(
                        6,
                        null,
                        new TreeNode(7)));

        System.out.println(solution.findTarget(root1, 9));
        // Answer: true

        // Test Case 2
        TreeNode root2 = new TreeNode(
                5,
                new TreeNode(
                        3,
                        new TreeNode(2),
                        new TreeNode(4)),
                new TreeNode(
                        6,
                        null,
                        new TreeNode(7)));

        System.out.println(solution.findTarget(root2, 28));
        // Answer: false

        // Test Case 3
        TreeNode root3 = new TreeNode(
                1,
                new TreeNode(0),
                new TreeNode(2));

        System.out.println(solution.findTarget(root3, 2));
        // Answer: true

        // Test Case 4
        TreeNode root4 = new TreeNode(
                2,
                new TreeNode(1),
                new TreeNode(3));

        System.out.println(solution.findTarget(root4, 5));
        // Answer: true

        // Test Case 5
        TreeNode root5 = new TreeNode(
                5,
                new TreeNode(3),
                new TreeNode(6));

        System.out.println(solution.findTarget(root5, 20));
        // Answer: false
    }
}