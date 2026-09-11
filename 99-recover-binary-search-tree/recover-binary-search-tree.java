class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        // Swap the values of the two misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // Detect violation
        if (prev.val > node.val) {
            if (first == null) {
                first = prev;   // first wrong node
            }
            second = node;      // second wrong node
        }
        prev = node;

        inorder(node.right);
    }
}
