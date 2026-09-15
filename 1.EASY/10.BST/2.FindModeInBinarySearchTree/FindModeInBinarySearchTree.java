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


// RANK 1: In-Order Traversal + Frequency Counting — O(n) TIME, O(h) STACK SPACE — BEST / OPTIMAL / MOST SPACE-EFFICIENT

class Solution {

    private Integer previous = null;
    private int currentCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;

    public int[] findMode(TreeNode root) {

        // First pass: find maximum frequency
        findMax(root);

        // Reset for second pass
        previous = null;
        currentCount = 0;

        int[] modes = new int[modeCount];
        int[] index = {0};

        // Second pass: collect all modes
        collectModes(root, modes, index);

        return modes;
    }

    private void findMax(TreeNode root) {

        if (root == null) {
            return;
        }

        findMax(root.left);

        if (previous != null && previous == root.val) {
            currentCount++;
        } else {
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modeCount = 1;
        } else if (currentCount == maxCount) {
            modeCount++;
        }

        previous = root.val;

        findMax(root.right);
    }

    private void collectModes(TreeNode root, int[] modes, int[] index) {

        if (root == null) {
            return;
        }

        collectModes(root.left, modes, index);

        if (previous != null && previous == root.val) {
            currentCount++;
        } else {
            currentCount = 1;
        }

        if (currentCount == maxCount) {
            modes[index[0]++] = root.val;
        }

        previous = root.val;

        collectModes(root.right, modes, index);
    }
}


// RANK 2: HashMap + DFS — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND
/*
import java.util.*;

class Solution {

    public int[] findMode(TreeNode root) {

        HashMap<Integer, Integer> map = new HashMap<>();

        countFrequency(root, map);

        int max = 0;

        for (int frequency : map.values()) {
            max = Math.max(max, frequency);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }

        int[] modes = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            modes[i] = result.get(i);
        }

        return modes;
    }

    private void countFrequency(
        TreeNode root,
        HashMap<Integer, Integer> map
    ) {

        if (root == null) {
            return;
        }

        map.put(
            root.val,
            map.getOrDefault(root.val, 0) + 1
        );

        countFrequency(root.left, map);
        countFrequency(root.right, map);
    }
}
*/


// RANK 3: In-Order Traversal + ArrayList — O(n) TIME, O(n) SPACE — SIMPLE / BST-BASED ALTERNATIVE
/*
import java.util.*;

class Solution {

    public int[] findMode(TreeNode root) {

        ArrayList<Integer> values = new ArrayList<>();

        inorder(root, values);

        int maxCount = 0;
        ArrayList<Integer> modes = new ArrayList<>();

        int i = 0;

        while (i < values.size()) {

            int value = values.get(i);
            int count = 0;

            while (i < values.size() && values.get(i) == value) {
                count++;
                i++;
            }

            if (count > maxCount) {
                maxCount = count;
                modes.clear();
                modes.add(value);
            } else if (count == maxCount) {
                modes.add(value);
            }
        }

        int[] result = new int[modes.size()];

        for (int j = 0; j < modes.size(); j++) {
            result[j] = modes.get(j);
        }

        return result;
    }

    private void inorder(TreeNode root, ArrayList<Integer> values) {

        if (root == null) {
            return;
        }

        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }
}
*/


// Driver code to test the Solution class
public class FindModeInBinarySearchTree {
    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test 1:
        //       1
        //        \
        //         2
        //        /
        //       2
        //
        // Answer: [2]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(2);

        System.out.println(
            "Test 1: " +
            java.util.Arrays.toString(solution.findMode(root1)) +
            "    // Answer: [2]"
        );


        // Test 2:
        //       1
        //
        // Answer: [1]
        TreeNode root2 = new TreeNode(1);

        System.out.println(
            "Test 2: " +
            java.util.Arrays.toString(solution.findMode(root2)) +
            "    // Answer: [1]"
        );


        // Test 3:
        //         2
        //        / \
        //       1   3
        //
        // All values appear once.
        // Answer: [1, 2, 3]
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(3);

        System.out.println(
            "Test 3: " +
            java.util.Arrays.toString(solution.findMode(root3)) +
            "    // Answer: [1, 2, 3]"
        );


        // Test 4:
        //          2
        //         / \
        //        1   3
        //           /
        //          3
        //
        // Answer: [3]
        TreeNode root4 = new TreeNode(2);
        root4.left = new TreeNode(1);
        root4.right = new TreeNode(3);
        root4.right.left = new TreeNode(3);

        System.out.println(
            "Test 4: " +
            java.util.Arrays.toString(solution.findMode(root4)) +
            "    // Answer: [3]"
        );


        // Test 5:
        //          5
        //         / \
        //        3   7
        //       / \ / \
        //      3  4 7  8
        //
        // Answer: [3, 7]
        TreeNode root5 = new TreeNode(5);

        root5.left = new TreeNode(3);
        root5.right = new TreeNode(7);

        root5.left.left = new TreeNode(3);
        root5.left.right = new TreeNode(4);

        root5.right.left = new TreeNode(7);
        root5.right.right = new TreeNode(8);

        System.out.println(
            "Test 5: " +
            java.util.Arrays.toString(solution.findMode(root5)) +
            "    // Answer: [3, 7]"
        );


        // Test 6:
        //          4
        //         / \
        //        2   6
        //       / \ / \
        //      2  3 6  7
        //
        // Answer: [2, 6]
        TreeNode root6 = new TreeNode(4);

        root6.left = new TreeNode(2);
        root6.right = new TreeNode(6);

        root6.left.left = new TreeNode(2);
        root6.left.right = new TreeNode(3);

        root6.right.left = new TreeNode(6);
        root6.right.right = new TreeNode(7);

        System.out.println(
            "Test 6: " +
            java.util.Arrays.toString(solution.findMode(root6)) +
            "    // Answer: [2, 6]"
        );


        // Test 7:
        //          1
        //           \
        //            1
        //             \
        //              1
        //
        // Answer: [1]
        TreeNode root7 = new TreeNode(1);
        root7.right = new TreeNode(1);
        root7.right.right = new TreeNode(1);

        System.out.println(
            "Test 7: " +
            java.util.Arrays.toString(solution.findMode(root7)) +
            "    // Answer: [1]"
        );


        // Test 8:
        //           6
        //          / \
        //         4   8
        //        / \ / \
        //       4  5 8  9
        //      /
        //     4
        //
        // Answer: [4]
        TreeNode root8 = new TreeNode(6);

        root8.left = new TreeNode(4);
        root8.right = new TreeNode(8);

        root8.left.left = new TreeNode(4);
        root8.left.right = new TreeNode(5);

        root8.right.left = new TreeNode(8);
        root8.right.right = new TreeNode(9);

        root8.left.left.left = new TreeNode(4);

        System.out.println(
            "Test 8: " +
            java.util.Arrays.toString(solution.findMode(root8)) +
            "    // Answer: [4]"
        );
    }
}