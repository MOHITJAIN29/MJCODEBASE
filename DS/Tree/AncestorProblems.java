/**
 * Created by 1021343 on 10-Oct-17.
 */

import java.util.*;
public class AncestorProblems {

    /*
                    12
                  /    \
                10		14
                / \       \
               8  11       16
                            \
                            18
    */
    public static void main(String arg[]) {

        Tree t = new Tree();
        t.createTree(new int[]{12, 14, 16, 10, 8, 6, 18,11});
        System.out.println("The LCA of 18 and 16 is "+findLCAInternal(t.root,18,16));
        System.out.println("The LCA of 8 and 11 is "+findLCAInternal(t.root,8,11));
        System.out.println("The LCA of 8 and 18 is "+findLCAInternal(t.root,8,18));
        System.out.println("The LCA of 18 and 16 is "+LCAOfBSTIterative(t.root,18,16));
        System.out.println("The LCA of 8 and 11 is "+LCAOfBSTIterative(t.root,8,11));
        System.out.println("The LCA of 8 and 18 is "+LCAOfBSTIterative(t.root,8,18));
        System.out.println("Ancestors of Given Node 21 are : ");
        printAncestors(t.root,11);
    }
    //here we are iteratively checking whether it is present in left subtree or right
    public static int LCAOfBSTIterative(TreeNode root, int n1, int n2) {

        while (root != null) {

            if (root.data > n1 && root.data > n2) {
                root = root.left;
            }
           else if (root.data < n1 && root.data < n2) {
                root = root.right;
            }
            else
                break;

        }
        return root.data;
    }


//Here we are first finding paths from root to n1 and n2 respectively and then checking for the lowest common ancestor(LCA) presents in both list
    private static int findLCAInternal(TreeNode root, int n1, int n2) {
         List<Integer> path1 = new ArrayList<>();
         List<Integer> path2 = new ArrayList<>();

        // check if both n1 and n2 are present or not
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

//        checking for the lowest common ancestor(LCA) presents in both list
        return path1.get(i-1);
    }

    private static boolean findPath(TreeNode root, int n, List<Integer> path)
    {
        if (root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        //nodes are not present so remove it from list and return false
        path.remove(path.size()-1);

        return false;
    }

    private static boolean printAncestors(TreeNode node, int target)
    {
        if (node == null)
            return false;

        if (node.data == target)
            return true;

        if (printAncestors(node.left, target) || printAncestors(node.right, target))
        {
            System.out.print(node.data + " ");
            return true;
        }

        return false;
    }



}
