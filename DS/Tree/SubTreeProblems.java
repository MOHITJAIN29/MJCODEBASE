/**
 * Created by 1021343 on 10-Oct-17.
 */
public class SubTreeProblems {

/*
                    12
                  /    \
                10		14               14               10
                / \       \                \             /  \
               8  11       16              16           8    11
                            \                \
                            18                18
    */

    public static void main(String arg[]) {

        Tree t = new Tree();
        t.createTree(new int[]{12, 14, 16, 10, 8, 6, 18, 11});
        TreeNode sRoot = new TreeNode(14);
        sRoot.right = new TreeNode(16);
        sRoot.right.right = new TreeNode(18);
        System.out.println("are Identical : "+areIdentical(t.root,sRoot));
        System.out.println("is Subtree : "+isSubtree(t.root,sRoot));
        System.out.println("is Subtree : "+isSubtree(t.root,new TreeNode(18)));


    }

   static boolean areIdentical(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;


        return (root1.data == root2.data
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right));
    }

    static boolean isSubtree(TreeNode root, TreeNode sRoot) {
        if (sRoot == null)
            return true;

        if (root == null)
            return false;

        if (areIdentical(root, sRoot))
            return true;

        return isSubtree(root.left, sRoot)
                || isSubtree(root.right, sRoot);
    }

}
