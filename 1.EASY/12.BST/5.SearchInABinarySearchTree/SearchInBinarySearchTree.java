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


// RANK 1: Iterative BST Search — O(log n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
            TreeNode currNode = root;
            while (currNode != null) {
                    if (currNode.val == val) {
                            return currNode;
                    } else if (val < currNode.val) {
                            currNode = currNode.left;
                    } else {
                            currNode = currNode.right;
                    }
            }
            return null;    
    }
}

// RANK 2: Recursive BST Search — O(h) TIME, O(h) SPACE — Simple / Natural
// class Solution {
//         public TreeNode searchBST(TreeNode root, int val) {
//                return  dfs(root, val);
//         }

//         private TreeNode dfs(TreeNode root, int val) {
//                 if (root == null) {
//                     return null;
//                 }
//                 if (root.val == val) {
//                         return root;
//                 }
//                 if (val < root.val) {
//                         return dfs(root.left, val);
//                 }
//                 return dfs(root.right, val);
//     }
// }

// RANK 3: Recursive Search with Ternary Return — O(h) TIME, O(h) SPACE — Compact Alternative
// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {
//
//         if (root == null || root.val == val) {
//             return root;
//         }
//
//         return val < root.val
//                 ? searchBST(root.left, val)
//                 : searchBST(root.right, val);
//     }
// }


// Driver code to test the Solution class
public class SearchInBinarySearchTree {

        public static void main(String[] args) {

                Solution solution = new Solution();

                // Test Case 1
                TreeNode root1 = new TreeNode(
                                4,
                                new TreeNode(
                                                2,
                                                new TreeNode(1),
                                                new TreeNode(3)),
                                new TreeNode(7));

                TreeNode result1 = solution.searchBST(root1, 2);

                System.out.println(result1 != null ? result1.val : null);
                // Answer: 2

                // Test Case 2
                TreeNode root2 = new TreeNode(
                                4,
                                new TreeNode(
                                                2,
                                                new TreeNode(1),
                                                new TreeNode(3)),
                                new TreeNode(7));

                TreeNode result2 = solution.searchBST(root2, 5);

                System.out.println(result2 != null ? result2.val : null);
                // Answer: null

                // Test Case 3
                TreeNode root3 = new TreeNode(
                                4,
                                new TreeNode(
                                                2,
                                                new TreeNode(1),
                                                new TreeNode(3)),
                                new TreeNode(7));

                TreeNode result3 = solution.searchBST(root3, 7);

                System.out.println(result3 != null ? result3.val : null);
                // Answer: 7

                // Test Case 4
                TreeNode root4 = new TreeNode(
                                8,
                                new TreeNode(
                                                3,
                                                new TreeNode(1),
                                                new TreeNode(6)),
                                new TreeNode(
                                                10,
                                                null,
                                                new TreeNode(14)));

                TreeNode result4 = solution.searchBST(root4, 6);

                System.out.println(result4 != null ? result4.val : null);
                // Answer: 6

                // Test Case 5
                TreeNode root5 = new TreeNode(5);

                TreeNode result5 = solution.searchBST(root5, 5);

                System.out.println(result5 != null ? result5.val : null);
                // Answer: 5

                // Test Case 6
                TreeNode root6 = new TreeNode(5);

                TreeNode result6 = solution.searchBST(root6, 10);

                System.out.println(result6 != null ? result6.val : null);
                // Answer: null
        }
}