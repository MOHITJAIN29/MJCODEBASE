import java.util.LinkedList;

/**
 * Created by 1021343 on 25-Oct-17.
 */
import java.util.*;
public class BTtoBSTConversion {

/*

                    15
                  /    \
                10		5           --Binary Tree
               / \     / \
              6   4   2   3


                    5
                  /    \
                3		10
               / \     / \         --BST (here structure should remain same as BT, just we are copying data )
              2   4   6   15


   */


    public static void main(String arg[]) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        Tree.levelOrderTraversalLineByLine(root);
        BTtoBST(root);
        System.out.println("Converted BST :");
        Tree.levelOrderTraversalLineByLine(root);
    }

    private static void BTtoBST(TreeNode root) {
        LinkedList<Integer> tree = new LinkedList<>();
        inOrder(root,tree);
        Collections.sort(tree);
        BTtoBST(root,tree);
    }
    private static void inOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inOrder(root.left,list);
        list.add(root.data);
        inOrder(root.right,list);
    }
    private static void BTtoBST(TreeNode root, List<Integer> list) {
        if(root == null) return;
        BTtoBST(root.left,list);
        root.data = list.remove(0);
        BTtoBST(root.right,list);
    }





}
