// ============================ FINAL DESTINATION ============================

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

// RANK 1: DFS Recursion — O(n) TIME, O(h) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (isLeft && root.left == null && root.right == null) {
            return root.val;
        }
        int leftSum = dfs(root.left, true);
        int rightSum = dfs(root.right, false);

        return leftSum + rightSum;
    }
}

// RANK 2: DFS Recursion — Check Left Child Directly — O(n) TIME, O(h) SPACE — Simple / Direct
// class Solution {
//     public int sumOfLeftLeaves(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }

//         int sum = 0;

//         if (root.left != null && root.left.left == null && root.left.right == null) {
//             sum += root.left.val;
//         }

//         sum += sumOfLeftLeaves(root.left);
//         sum += sumOfLeftLeaves(root.right);

//         return sum;
//     }
// }

// RANK 3: Iterative DFS with Stack — O(n) TIME, O(h) SPACE — Iterative Alternative
// import java.util.*;
//
// class Solution {
//     public int sumOfLeftLeaves(TreeNode root) {
//
//         if (root == null) {
//             return 0;
//         }
//
//         Stack<TreeNode> nodeStack = new Stack<>();
//         Stack<Boolean> leftStack = new Stack<>();
//
//         nodeStack.push(root);
//         leftStack.push(false);
//
//         int sum = 0;
//
//         while (!nodeStack.isEmpty()) {
//
//             TreeNode current = nodeStack.pop();
//             boolean isLeft = leftStack.pop();
//
//             if (isLeft
//                     && current.left == null
//                     && current.right == null) {
//                 sum += current.val;
//             }
//
//             if (current.left != null) {
//                 nodeStack.push(current.left);
//                 leftStack.push(true);
//             }
//
//             if (current.right != null) {
//                 nodeStack.push(current.right);
//                 leftStack.push(false);
//             }
//         }
//
//         return sum;
//     }
// }


// Driver code to test the Solution class
public class SumOfLeftLeaves {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        TreeNode root1 = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)));

        System.out.println(solution.sumOfLeftLeaves(root1));
        // Answer: 24

        // Test Case 2
        TreeNode root2 = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3));

        System.out.println(solution.sumOfLeftLeaves(root2));
        // Answer: 2

        // Test Case 3
        TreeNode root3 = new TreeNode(
                1,
                null,
                new TreeNode(2));

        System.out.println(solution.sumOfLeftLeaves(root3));
        // Answer: 0

        // Test Case 4
        TreeNode root4 = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));

        System.out.println(solution.sumOfLeftLeaves(root4));
        // Answer: 4
    }
}