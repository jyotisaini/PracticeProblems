/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

       1
      / \
     2   3
*/

    long maxsum = Integer.MIN_VALUE;
      public int maxPathSum(TreeNode a) {
        if(a ==null)
            return 0;
        if(a.left==null && a.right ==null)
                return a.val;
        recur(a);
        return (int)maxsum;

    }

    public int recur(TreeNode node){

        if(node == null){
            return Integer.MIN_VALUE;
        }

        if(node.left == null && node.right==null){
            return node.val;
        }

        long leftval = recur(node.left);
        long rightval = recur(node.right);
        long maxchildval = Math.max(leftval, rightval);
        long maxrootchildval = Math.max(node.val, Math.max(maxchildval, maxchildval + node.val));

        long maxsubtree = Math.max(maxrootchildval, node.val + leftval + rightval);

        maxsum = Math.max(maxsubtree, maxsum);

        return (int)maxrootchildval;
    }

