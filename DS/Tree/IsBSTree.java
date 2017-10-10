/**
 * Created by 1021343 on 10-Oct-17.
 */
import java.util.*;

public class IsBSTree {
    static TreeNode prev =null;
    public static void main(String arg[]) {

        Tree t = new Tree();
        t.createTree(new int[]{12, 14, 16, 10, 8, 6, 18, 13, 15, 11, 9});
        System.out.println("is Given Tree is BST : "+isBSTUsingRange(t.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println("is Given Tree is BST : "+isBSTUsingInorder(t.root));
        System.out.println("is Given Tree is BST : "+isBST(t.root));
        t.root.left.right.data = 17;
        System.out.println("is Given Tree is BST : "+isBSTUsingRange(t.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println("is Given Tree is BST : "+isBSTUsingInorder(t.root));
        System.out.println("is Given Tree is BST : "+isBST(t.root));



    }
// here we decide the min and max range of data for each node
   public  static boolean isBSTUsingRange(TreeNode node, int min, int max)
    {
        if (node == null)
            return true;
        if (node.data < min || node.data > max)
            return false;
        return (isBSTUsingRange(node.left, min, node.data-1) && isBSTUsingRange(node.right, node.data+1, max));
    }
// do the inorder of BST and check if prev node < current node if it is then true
    public static boolean isBSTUsingInorder(TreeNode node)
    {

        if (node != null)
        {
            if (!isBSTUsingInorder(node.left))
                return false;

            if (prev != null && node.data <= prev.data )
                return false;
            prev = node;
            return isBSTUsingInorder(node.right);
        }
        return true;
    }
//do inorder of Given BST and check with updated list if it is in ascending order
    public static boolean isBST(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        if (root == null) return true;
        inOrder(root, list);
        for (int i = -1; i < list.size()-2; i++) {
            if (list.get(i+1).data > list.get(i+2).data)
                return false;
        }
        return true;
    }
    public static void inOrder(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

}
