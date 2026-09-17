/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private int postIndex;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start from the last element in postorder (root)
        postIndex = postorder.length - 1;

        // Map inorder values to their indices for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return arrayToTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        // Base case
        if (left > right) return null;

        // Pick current root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Build right subtree first, then left
        root.right = arrayToTree(postorder, inorderMap.get(rootVal) + 1, right);
        root.left = arrayToTree(postorder, left, inorderMap.get(rootVal) - 1);

        return root;
    }
}
