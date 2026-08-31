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

// RANK 1: DFS + Height (Single Traversal) — O(n) Time, O(h) Space — BEST PRACTICAL / MOST EFFICIENT / INTERVIEW FAVORITE
class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }
}
 
// RANK 2: Postorder DFS with Pair Return — O(n) Time, O(h) Space — CLEAN / EFFICIENT / NO GLOBAL STATE
// class Solution {

//     class Pair {
//         int height;
//         int diameter;
//     }

//     public int diameterOfBinaryTree(TreeNode root) {
//         return dfs(root).diameter;
//     }

//     private Pair dfs(TreeNode node) {
//         Pair p = new Pair();
//         if (node == null) return p;

//         Pair left = dfs(node.left);
//         Pair right = dfs(node.right);

//         p.height = Math.max(left.height, right.height) + 1;
//         p.diameter = Math.max(left.height + right.height, Math.max(left.diameter, right.diameter));

//         return p;
//     }
// }

// RANK 3: DFS with Global Object Wrapper — O(n) Time, O(h) Space — CLEAN / AVOID GLOBAL STATE / GOOD ALTERNATIVE
// class Solution {
//     class Result {
//         int diameter = 0;
//     }

//     public int diameterOfBinaryTree(TreeNode root) {
//         Result res = new Result();
//         height(root, res);
//         return res.diameter;
//     }

//     private int height(TreeNode node, Result res) {
//         if (node == null) return 0;

//         int left = height(node.left, res);
//         int right = height(node.right, res);

//         res.diameter = Math.max(res.diameter, left + right);

//         return Math.max(left, right) + 1;
//     }
// }


// RANK 4: Brute Force — O(n²) Time, O(h) Space — SIMPLE / EASY TO UNDERSTAND / LEAST EFFICIENT
// class Solution {
//     public int diameterOfBinaryTree(TreeNode root) {
//         if (root == null) return 0;

//         int leftHeight = height(root.left);
//         int rightHeight = height(root.right);

//         int leftDiameter = diameterOfBinaryTree(root.left);
//         int rightDiameter = diameterOfBinaryTree(root.right);

//         return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
//     }

//     private int height(TreeNode node) {
//         if (node == null) return 0;
//         return Math.max(height(node.left), height(node.right)) + 1;
//     }
// }

// Driver code to test the Solution class
public class DiameterOfBinaryTree {
    public static void main(String[] args) {

        // Create binary tree:
        //
        //          1
        //         / \
        //        2   3
        //       / \
        //      4   5
        //
        // Diameter = 3
        // Path: 4 → 2 → 1 → 3

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution obj = new Solution();

        // Test 1
        System.out.println("Diameter: " + obj.diameterOfBinaryTree(root));
        // Diameter: 3


        // Test 2
        // Tree:
        //
        //      1
        //       \
        //        2
        //         \
        //          3
        //
        // Diameter = 2

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);

        System.out.println("Diameter: " + obj.diameterOfBinaryTree(root2));
        // Diameter: 2


        // Test 3
        // Single node → Diameter = 0

        TreeNode root3 = new TreeNode(1);

        System.out.println("Diameter: " + obj.diameterOfBinaryTree(root3));
        // Diameter: 0
    }
}