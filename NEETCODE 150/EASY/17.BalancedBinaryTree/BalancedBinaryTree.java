// ============================ JULY-AUGUST PRACTICE ============================

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

// RANK 1: Bottom-Up DFS (BEST / MOST EFFICIENT) — O(n), O(h)
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        if (left == -1) return -1;

        int right = dfs(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}

// RANK 2: Pair / Wrapper Class Approach — O(n), O(h)
// class Solution {

//     class Pair {
//         int height;
//         boolean balanced;
//         Pair(int h, boolean b) {
//             height = h;
//             balanced = b;
//         }
//     }

//     public boolean isBalanced(TreeNode root) {
//         return helper(root).balanced;
//     }

//     private Pair helper(TreeNode node) {
//         if (node == null) return new Pair(0, true);

//         Pair left = helper(node.left);
//         Pair right = helper(node.right);

//         boolean isBal = left.balanced &&
//                         right.balanced &&
//                         Math.abs(left.height - right.height) <= 1;

//         int h = 1 + Math.max(left.height, right.height);

//         return new Pair(h, isBal);
//     }
// }

// RANK 3: Using Global Boolean Flag — O(n), O(h)
// class Solution {
//     boolean balanced = true;

//     public boolean isBalanced(TreeNode root) {
//         height(root);
//         return balanced;
//     }

//     private int height(TreeNode node) {
//         if (node == null) return 0;

//         int left = height(node.left);
//         int right = height(node.right);

//         if (Math.abs(left - right) > 1) balanced = false;

//         return 1 + Math.max(left, right);
//     }
// }

// RANK 4: Top-Down Recursion (BRUTE FORCE) — O(n²), O(h)
// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if (root == null) {
//             return true;
//         }
//         int left = height(root.left);
//         int right = height(root.right);
//         // if (Math.abs(left - right) > 1) {
//         //     return false;
//         // } 
//         // return isBalanced(root.left) && isBalanced(root.right);
//         return Math.abs(left - right) <= 1
//         && isBalanced(root.left)
//         && isBalanced(root.right);
//     }
//     private int height(TreeNode root){
//         if (root == null) {
//             return 0;
//         }
//         return 1 + Math.max(height(root.left), height(root.right));
//     }
// }

// Driver code to test the Solution class
public class BalancedBinaryTree {

    public static void main(String[] args) {

        /*
                  3
                 / \
                9   20
                   /  \
                  15   7

            Expected Answer: true
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();

        boolean result = solution.isBalanced(root);

        System.out.println("Is Balanced: " + result);
    }
}