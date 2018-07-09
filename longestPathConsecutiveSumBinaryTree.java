/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 

*/class TreeVal {
        int val;
        int len=0;

        TreeVal(int v, int l){
            val=v;
            len=l;
        }
    }
    public  int len = Integer.MIN_VALUE;
    public  int longestPathBinaryTree(TreeNode a)
    {
        if(a==null )
            return 0;

        if(a.left==null && a.right==null)
            return a.val;
        longestPathBinaryTreeHelper(a);
        return len;

    }

   public TreeVal longestPathBinaryTreeHelper( TreeNode a) {
        if(a==null)
            return null;

        if(a.left== null && a.right ==null)
        {
            return new TreeVal(a.val, 1);
        }

        TreeVal left = longestPathBinaryTreeHelper(a.left);
        TreeVal right = longestPathBinaryTreeHelper(a.right);
        if(left.val+1==a.val && a.val+1==right.val)
       {
           len = len<(left.len +right.len+1) ?left.len +right.len+1 : len;
           return new TreeVal(a.val, Math.max(left.len+1, right.len+1));
       }

     else  if(left.val+1==a.val)
       {
           len = len<(left.len+1) ?left.len+1 : len;
           return new TreeVal(a.val, left.len+1);
       }
       else if(a.val+1==right.val)
        {
            len = len<(right.len+1) ?right.len+1 : len;
            return new TreeVal(a.val, right.len+1);
        }

        return new TreeVal(a.val, 1);
   }
