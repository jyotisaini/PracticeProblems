/*

Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL

*/

public TreeNode flatten(TreeNode a) {
        if (a == null || (a.left == null && a.right == null))
            return a;
        TreeNode root = a, t=a;
        while (root.left!=null || root.right!=null) {
            a = root;
            if (a.left != null) {
                TreeNode temp = a.right;
                a.right = a.left;
                while (a.right != null)
                    a = a.right;
                a.right = temp;
                root.left = null;
            }
            root= root.right;
        }
        return t;
    }
}
