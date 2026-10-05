// ============================ FINAL DESTINATION ============================

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// RANK 1: DFS Recursion with Remaining Sum — O(n) TIME, O(h) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean result = dfs(root, targetSum);
        return result;
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        return dfs(root.left, targetSum) || dfs(root.right, targetSum);
    }
}


// RANK 2: DFS Recursion with Running Sum — O(n) TIME, O(h) SPACE — Simple / Direct

// class Solution {
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//
//         return dfs(root, 0, targetSum);
//     }
//
//     private boolean dfs(TreeNode root, int currentSum, int targetSum) {
//
//         if (root == null) {
//             return false;
//         }
//
//         currentSum += root.val;
//
//         if (root.left == null && root.right == null) {
//             return currentSum == targetSum;
//         }
//
//         return dfs(root.left, currentSum, targetSum)
//                 || dfs(root.right, currentSum, targetSum);
//     }
// }


// RANK 3: Iterative DFS with Stack — O(n) TIME, O(h) SPACE — Iterative Alternative

// import java.util.Stack;

// class Solution {
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//
//         if (root == null) {
//             return false;
//         }
//
//         Stack<TreeNode> nodes = new Stack<>();
//         Stack<Integer> sums = new Stack<>();
//
//         nodes.push(root);
//         sums.push(root.val);
//
//         while (!nodes.isEmpty()) {
//
//             TreeNode current = nodes.pop();
//             int currentSum = sums.pop();
//
//             if (current.left == null && current.right == null) {
//
//                 if (currentSum == targetSum) {
//                     return true;
//                 }
//             }
//
//             if (current.right != null) {
//                 nodes.push(current.right);
//                 sums.push(currentSum + current.right.val);
//             }
//
//             if (current.left != null) {
//                 nodes.push(current.left);
//                 sums.push(currentSum + current.left.val);
//             }
//         }
//
//         return false;
//     }
// }



// Driver code to test the Solution class
public class PathSum {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        TreeNode root1 = new TreeNode(
                5,
                new TreeNode(
                        4,
                        new TreeNode(
                                11,
                                new TreeNode(7),
                                new TreeNode(2)
                        ),
                        null
                ),
                new TreeNode(
                        8,
                        new TreeNode(13),
                        new TreeNode(
                                4,
                                null,
                                new TreeNode(1)
                        )
                )
        );

        System.out.println(solution.hasPathSum(root1, 22));
        // Answer: true


        // Test Case 2
        TreeNode root2 = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        );

        System.out.println(solution.hasPathSum(root2, 5));
        // Answer: false


        // Test Case 3
        TreeNode root3 = new TreeNode(1);

        System.out.println(solution.hasPathSum(root3, 1));
        // Answer: true


        // Test Case 4
        TreeNode root4 = new TreeNode(
                1,
                new TreeNode(2),
                null
        );

        System.out.println(solution.hasPathSum(root4, 1));
        // Answer: false


        // Test Case 5
        TreeNode root5 = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        null
                ),
                new TreeNode(4)
        );

        System.out.println(solution.hasPathSum(root5, 6));
        // Answer: true


        // Test Case 6
        TreeNode root6 = null;

        System.out.println(solution.hasPathSum(root6, 0));
        // Answer: false
    }
}