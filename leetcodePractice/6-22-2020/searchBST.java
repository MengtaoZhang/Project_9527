/*
二叉树的查找
6-22-2020
*/
public TreeNode searchBST (TreeNode root, int val) {
    if (root == null) {
        return null;
    } // 未找到值为val的节点
    if (val < root.val) {
        return searchBST(root.left, val); // val小于根节点值，在左子树中查找
    } else if (val > root.val) {
        return searchBST(root.right, val); // val值大于根节点值，在右子树中查找
    } else {
        return root; // find it
    }
}
