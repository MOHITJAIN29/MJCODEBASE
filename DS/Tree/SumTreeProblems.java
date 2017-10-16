
/**
 * Created by 1021343 on 12-Oct-17.
 */

/*

Children Sum property-  For every node, data value must be equal to sum of data values in left and right children
                    15
                  /    \
                10		5
               / \     / \
              6   4   2   3


Sum Tree- A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree.
          An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree
                    30
                  /    \
                10		5
               / \     / \
              6   4   2   3

 */
public class SumTreeProblems {


    public static void main(String arg[]) {

        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(10);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println("Children Sum property for given tree is --> "+isChildrenSum(root));
        System.out.println("The Given Tree is Sum Tree --> "+isSumTreeRecursive(root));
        System.out.println("The Given Tree is Sum Tree --> "+isSumTreeOptimized(root));
        Tree t = new Tree();
        t.createTree(new int[]{12, 14, 16, 10, 8, 13,11});
        System.out.println("The Level order of given Tree is :- ");
        t.levelOrderTraversalLineByLine(t.root);
        System.out.println("The Level order of Converted Sum-Tree  is :- ");
//        System.out.println("Children Sum property for given tree is --> "+isSumTree(root));
        t.levelOrderTraversalLineByLine(convertToSumTree(t.root));

    }


    private static boolean isSumTreeRecursive(TreeNode root) {
        if(root == null || isLeaf(root)) {
            return true;
        }else {
            return root.data == sum(root.left) + sum(root.right) && isSumTreeRecursive(root.left) && isSumTreeRecursive(root.right);
        }
    }

    private static TreeNode convertToSumTree(TreeNode root) {
        if (root == null) return null;
        root.data = sum(root.left) + sum(root.right);
        convertToSumTree(root.left);
        convertToSumTree(root.right);
        return root;
    }



    //Children sum property : -"For every node, data value must be equal to sum of data values in left and right children"
    private static boolean isChildrenSum(TreeNode node)
    {
        if(node == null || isLeaf(node)) {
            return true;
        }

        int ldata=0, rdata=0;

        if(node.left != null) {
            ldata = node.left.data;
        }

        if(node.right != null) {
            rdata = node.right.data;
        }

        return (node.data == ldata + rdata) &&  isChildrenSum(node.left) && isChildrenSum(node.right);
    }
    private static boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        return (root.left == null && root.right == null);
    }
    private static int sum(TreeNode root) {
        if (root == null) return 0;
        else return root.data + sum(root.left) + sum(root.right);
    }

    private static boolean  isSumTreeOptimized(TreeNode root)
    {
        int ldata;
        int rdata;

        /* If node is NULL or it's a leaf node then
         return true */
        if (root == null || isLeaf(root))
            return true;
        else
        {
            int leftSum = 0;
            if (root.left == null)
                leftSum = 0;
            else if (isLeaf(root.left))
                leftSum = root.left.data;
            else
                leftSum = 2 * root.left.data;

            int rightSum = 0;
            if (root.right == null)
                rightSum = 0;
            else if (isLeaf(root.right))
                rightSum = root.right.data;
            else
                rightSum = 2 * root.right.data;

            return root.data == (leftSum + rightSum) && (isSumTreeOptimized(root.left) )&& (isSumTreeOptimized(root.right));
        }


    }

}
